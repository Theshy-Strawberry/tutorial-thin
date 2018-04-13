package jp.terasoluna.thin.tutorial.web.common.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jp.terasoluna.fw.exception.SystemException;
import jp.terasoluna.fw.service.thin.AbstractBLogicMapper;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicIO;
import jp.terasoluna.fw.service.thin.BLogicResources;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.fw.util.PropertyUtil;
import jp.terasoluna.fw.web.struts.ModuleUtil;
import jp.terasoluna.fw.web.struts.action.ActionMappingEx;
import jp.terasoluna.fw.web.struts.actions.ActionEx;
import net.sf.json.JSONArray;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class AjaxBLogicAction<P> extends ActionEx {
	private static Log log = LogFactory.getLog(AjaxBLogicAction.class);
	protected static final String BLOGIC_FORM_ILLEGAL_ERROR = "errors.blogic.form";
	protected static final String BLOGIC_MAPPING_ILLEGAL_ERROR = "errors.blogic.mapping";
	protected static final String BLOGIC_RESOURCES_ILLEGAL_ERROR = "errors.blogic.resources";
	protected static final String BLOGIC_RESULT_NULL_ERROR = "errors.blogic.result.null";
	protected static final String NULL_MAPPER_KEY = "errors.blogic.mapper.null";
	private BLogic<P> businessLogic;

	public AjaxBLogicAction() {
		this.businessLogic = null;
	}

	public void setBusinessLogic(BLogic<P> businessLogic) {
		this.businessLogic = businessLogic;
	}

	public BLogic<P> getBusinessLogic() {
		return this.businessLogic;
	}

	@SuppressWarnings("deprecation")
	public ActionForward doExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		ActionMappingEx mappingEx = null;
		try {
			mappingEx = (ActionMappingEx) mapping;
		} catch (ClassCastException e) {
			log.error("Illegal ActionMapping.");
			throw new SystemException(e, "errors.blogic.mapping");
		}
		@SuppressWarnings("unchecked")
		P params = (P) getBLogicParams(mappingEx, req, res);

		if (this.businessLogic == null) {
			return null;
		}

		if (log.isDebugEnabled()) {
			log.debug("*** Starting blogic["
					+ this.businessLogic.getClass().getName() + "]. ***");
		}

		BLogicResult result = this.businessLogic.execute(params);

		if (log.isDebugEnabled()) {
			log.debug("*** Finished blogic["
					+ this.businessLogic.getClass().getName() + "]. ***");
		}
		JSONArray jsonArray = JSONArray.fromObject(result.getResultObject());
		res.setCharacterEncoding("utf-8");
		res.getWriter().print(jsonArray);
		if (log.isDebugEnabled()) {
			log.debug("doExecute() called.");
		}

		String path = mapping.getParameter();

		ActionForward retVal = null;

		if (path == null) {
			retVal = mapping.findForward("success");

			if (retVal == null) {
				try {
					res.sendError(404);
				} catch (IOException e) {
					log.error("Error page(404) forwarding failed.");

					throw new SystemException(e, "error.forward.errorpage");
				}
				return null;
			}
			return null;
		}

		retVal = new ActionForward(path);

		String contextRelativeStr = PropertyUtil.getProperty(
				"forwardAction.contextRelative", Boolean.FALSE.toString());

		Boolean contextRelative = new Boolean(contextRelativeStr);

		retVal.setContextRelative(contextRelative.booleanValue());
		if (log.isDebugEnabled()) {
			StringBuilder debugLog = new StringBuilder();
			debugLog.append("contextRelative:");
			debugLog.append(contextRelative);
			log.debug(debugLog.toString());
		}

		return null;
	}

	protected Object getBLogicParams(ActionMappingEx mapping,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		BLogicIO io = getBLogicIO(mapping, request);

		Object bean = getBLogicMapper(request).mapBLogicParams(request,
				response, io);

		return bean;
	}

	protected AbstractBLogicMapper getBLogicMapper(HttpServletRequest req) {
		String moduleName = ModuleUtil.getPrefix(req);

		AbstractBLogicMapper mapper = null;
		try {
			mapper = (AbstractBLogicMapper) this.servlet.getServletContext()
					.getAttribute("BLOGIC_MAPPER" + moduleName);
		} catch (ClassCastException e) {
			log.error("Cannot cast BLogicMapper : " + e.getMessage());
			throw new SystemException(e, "errors.blogic.mapping");
		}

		if (mapper == null) {
			log.error("BLogicMapper is null.");
			throw new SystemException(new NullPointerException(),
					"errors.blogic.mapper.null");
		}

		return mapper;
	}

	protected BLogicIO getBLogicIO(ActionMapping mapping,
			HttpServletRequest request) {
		String moduleName = ModuleUtil.getPrefix(request);

		BLogicResources resource = null;
		try {
			resource = (BLogicResources) this.servlet.getServletContext()
					.getAttribute("BLOGIC_RESOURCES" + moduleName);
		} catch (ClassCastException e) {
			log.error("Cannot cast BLogicResources : " + e.getMessage());
			throw new SystemException(e, "errors.blogic.resources");
		}

		if (resource != null) {
			return resource.getBLogicIO(mapping.getPath());
		}
		return null;
	}

}