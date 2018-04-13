    //添加收件人
        function addTo(){
          var tempArray = new Array();
          tempArray = $("select[name='officeMail']").find("option:selected");
          var tempVal = "";
          $.each(tempArray,function(index,obj){
              tempVal += obj.value + ";";
          });
          var oldVal=$(".to").val();
          oldVal += tempVal;
          $(".to").val(oldVal);
        }
    //添加抄送人
        function addCC(){
          var tempArray = new Array();
          tempArray = $("select[name='officeMail']").find("option:selected");
          var tempVal = "";
          $.each(tempArray,function(index,obj){
              tempVal += obj.value + ";";
          });
          var oldVal=$(".cc").val();
          oldVal += tempVal;
          $(".cc").val(oldVal);
        }