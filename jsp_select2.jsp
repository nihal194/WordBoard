<%-- 
    Document   : index
    Created on : Feb 14, 2017, 6:32:34 PM
    Author     : nihal-pt1432
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="select2.css" rel="stylesheet" />
    
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Validate Words Application</title>
    </head>
    
    <body>
        <div class="container">
            <div class="jumbotron">
                <h2 align="center"><b>~<u> Words Validation Application </u>~</b></h2>
            <br>
               ${msg} 
            <form name="f1" action="Javafile" method="get" class="form-horizontol">
                <table align="center">
                    
                    <tr>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    </tr>
                    <tr>
                        <td><input id="moreWords2" autofocus="" placeholder='select item' /></td>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td><span id="showError" style="color:red"></span></td>
                    </tr>

                </table>
                              
            </form>
            </div>
        </div>    
    </body>
    <script src="jquery-1.8.3.min.js"></script>
    <script src="select2.min.js"></script>
    
        
    <script>
    
        $(document).ready(function(){
            var count=10;
            var listWords=null;
            var inputStr="";
            //var set2 = [{ id: 0, text: 'enhancement' }, { id: 1, text: 'bug' }, { id: 2, text: 'duplicate' }, { id: 3, text: 'invalid' }, { id: 4, text: 'wontfix' }];
            /*
        var Url = appendTimestamp('/servlet/SDAjaxServlet'); //No I18N
        var tempAjax = jQuery.ajax({
        dataType: "json",//No I18N
        url: Url,
        async:false,
        type: 'post', //No I18N
        data: {action: "isApprovalEnabled",module: "Request",woID:woId}, //No I18N
        success: function (resp) {
          if(resp.approvalNeeded=="Yes")//No I18N
          {
            var result=confirm(getMessageForKey("sdp.request.autoapproval.techwarning")); //No I18N
            if(!result)
            {
               jQuery('#pickupTech').attr('href',"javascript:(0)");//No I18N
               window.location.reload();
            }
          }
          return true;
        }
      })
           */  
          
           // var dataString="inputStr="+inputStr+" "+(count+10);
            //var dataString=;
            //console.log("dataString: "+dataString);
            
            $changeSel=jQuery("#moreWords2").select2({
                minimumInputLength: 1,
                allowClear:true,
                ajax: 
                        {
                        url: "Javafile",
                        dataType:"json",
                        data: function (term, page) {
                            //console.log("select2 data");
                            return {
                                inputStr:term,
                                page:page
                            };
                         },
                     /*
                processResults: function (data, params) {
                            // parse the results into the format expected by Select2
                            // since we are using custom formatting functions we do not need to
                            // alter the remote JSON data, except to indicate that infinite
                            // scrolling can be used
                           // params.page = params.page;

                            return {
                              results: data.matchedWords,
                              more: (params.page * 10) < data.totalFind
                            };
                      }, */
                  
                        results: function(data,page)
                        {
                            console.log(data.matchedArrayJSON)
                            
                            //console.log("DATA "+set2);
                            /*
                            var resultData =[]
                            //var i;
                            var errorInput="";
                            if(data.matchedWordsJSON!=undefined)
                            {
                                errorInput="";
                                                                
                                //console.log("select2 results data: "+data);
                                //inputStr=data.searchString;
                                //count=
                                //errorInput=""
                                
                                document.getElementById("showError").innerHTML=errorInput;
                                
                            }
                                /*
                                for (i = 1; i <= data.matchedWordsJSON.length; i++) {
                                    resultData.push({id: data.matchedWordsJSON[i-1],text:data.matchedWords[i-1]});
                                }
                            }
                            //else
                           // {
                             //   errorInput="Invalid Input";
                               // document.getElementById("showError").innerHTML=errorInput;
                            //}
                                
                            //results.callback(resultData);
                            //if(errorInput=="")
                              //  resultData.push({id:"More Words",text:"More Words"});
                            
                            */
                           return{
                                results: data.matchedArrayJSON,
                                more: (page * 10) < data.totalFind
                                };
                        }
                    //cache: true
                    
                }  
                /*query: function(query) 
                {
                    var data ={results:[]};
                    var i;
                    for (i = 0; i < set2.length; i++) {
                        if(set2[i].text.substr(query.term))
                            data.results.push({id: set2[i].id, text: set2[i].text});
                    }
                    query.callback(data);
                }*/
               
            });
    
            $("#moreWords2").change(function () {
                // Do something
                
                //console.log($('#moreWords2').val());
                var selOption=$('#moreWords2').val();
                //console.log(selOption);
                
                if(selOption=="More Words")
                {
                    //var newCount=count+10;
                    //console.log(newCount);
                    var xmlhttp=new XMLHttpRequest();
                    xmlhttp.onreadystatechange= functionSuggestion;
                    //console.log(inputStr+" "+(count+10));
                    xmlhttp.open("GET","Javafile?inputStr="+inputStr,false);
                    xmlhttp.send();
                }
                    
              });
            function sendRequest()
            {
               var inputStr=jQuery("#moreWords2").val();
               console.log(inputStr);
               //set2 = [{ id: 0, text: 'enhancement' }, { id: 1, text: 'bug' }, { id: 2, text: 'duplicate' }, { id: 3, text: 'invalid' }, { id: 4, text: 'wontfix' }];
               //var set2 = [{ id: 0, text: 'enhancement' }, { id: 1, text: 'bug' }, { id: 2, text: 'duplicate' }, { id: 3, text: 'invalid' }, { id: 4, text: 'wontfix' }];
                //var set2=["a","b","c","d"];
                
               //console.log(set2);
               //$("#moreWords2").select2({
                //data: set2
                //}); 
                /*
                if(inputStr.length>0)
                {
                    var xmlhttp=new XMLHttpRequest();
                    xmlhttp.onreadystatechange= functionSuggestion;
                    console.log(inputStr+" "+(count+10));
                    xmlhttp.open("GET","Javafile?inputStr="+inputStr+" "+(count+10),false);
                    xmlhttp.send();
                } */
        /*
         $("#profiles-thread").select2({
    minimumInputLength: 2,
    tags: [],
    ajax: {
        url: URL,
        dataType: 'json',
        type: "GET",
        quietMillis: 50,
        data: function (term) {
            return {
                term: term
            };
        },
        results: function (data) {
            return {
                results: $.map(data, function (item) {
                    return {
                        text: item.completeName,
                        slug: item.slug,
                        id: item.id
                    }
                })
            };
        }
    }
}); 
         
         */
            /*
                $("#moreWords2").select2({
                    placeholder: "Search for an Item",
                    minimumInputLength: 1,
                    data: set2,
                    ajax: {
                        url: "Javafile?inputStr="+inputStr+" "+(count+10),
                        dataType: 'json',
                        type: "GET",
                        success: function (resp) {
                        console.log(resp);
                        },
                    },
                });
                */
            }
            
            function functionSuggestion()
            {

                //console.log(this.status+":::I m here  "+this.readyState);       
                if(this.readyState==4 /*Complete*/ && this.status==200/*OK Response*/ )
                {
                    
                    var hintWords=this.responseText;
                    var wordsObj=JSON.parse(hintWords);
                    inputStr=wordsObj.searchString;
                   // console.log("Suggestion function: "+wordsObj);
                    $('#moreWords2').select2("data",wordsObj);
                    //count=0;
                      /*
                    var temp=count;
                    //var set2=wordsObj.matchedWords.slice(count,count+10);
                    //var set2=[{"id":"1","value":"adsfas"},{"id":"2","value":"adsfas"},{"id":"3","value":"adsfas"}];
                    //var set2 = [{ id: 0, text: 'enhancement' }, { id: 1, text: 'bug' }, { id: 2, text: 'duplicate' }, { id: 3, text: 'invalid' }, { id: 4, text: 'wontfix' }]

                    while(count<temp+10 && count<wordsObj.totalFind)
                    {
                        listWords+='<option value="'+wordsObj.matchedWords[count]+'">';
                        count++;
                    }
                 
                    console.log("set2 "+set2);
                    $("#words2").select2({
                        placeholder:"Matched Words",
                        data:set2
                    });
                    
                    if(count<wordsObj.totalFind)
                    {
                        //document.getElementById('moreWords').innerHTML= "+"+(wordsObj.matchedWords.length-count)
                       // listWords+='<option value="more words">';
                        document.getElementById('moreWords').innerHTML= "+ "+(wordsObj.totalFind-count)+" more found";
                    }
                    else if(count<=temp+10)
                    {
                        document.getElementById('moreWords').innerHTML= "no more matches";

                    }
                    else if(count<temp+1)
                    {
                        document.getElementById('moreWords').innerHTML= "no matches";

                    }
                   console.log(listWords);
                   document.getElementById('matchedWords').innerHTML=listWords;
                }*/
            }
        }
            
            
            $("#moreWords").mouseenter(function () {
                $(this).css({"color":"blue"});
            });
            
            $("#moreWords").mouseleave(function () {
                $(this).css({"color":"red"});
            });
           
            
            
    });
     
    </script>
    
</html>





