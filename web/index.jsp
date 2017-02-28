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
        <style>
           .heading { 
                     color: #d54d7b; 
                     font-family: "Vollkorn", cursive; 
                     font-size: 70px; 
                     line-height: 80px; 
                     font-weight: normal; 
                     margin-bottom: 0px; 
                     margin-top: 40px; 
                     text-align: center; 
                     text-shadow: 1px 3px #ffff00; 
            }
            #snackbar {
                visibility: hidden;
                font-family: "Vollkorn", cursive; 
                min-width: 250px;
                margin-left: -125px;
                background-color: #b3b3b3;
                color: #000;
                text-align: center;
                border-radius: 2px;
                padding: 16px;
                position: fixed;
                z-index: 1;
                left: 50%;
                bottom: 30px;
                font-size: 17px;
            }

            #snackbar.show {
                visibility: visible;
                -webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
                animation: fadein 0.5s, fadeout 0.5s 2.5s;
            }

            @-webkit-keyframes fadein {
                from {bottom: 0; opacity: 0;} 
                to {bottom: 30px; opacity: 1;}
            }

            @keyframes fadein {
                from {bottom: 0; opacity: 0;}
                to {bottom: 30px; opacity: 1;}
            }

            @-webkit-keyframes fadeout {
                from {bottom: 30px; opacity: 1;} 
                to {bottom: 0; opacity: 0;}
            }

            @keyframes fadeout {
                from {bottom: 30px; opacity: 1;}
                to {bottom: 0; opacity: 0;}
            }
        </style>
    </head>
    
    <body>
        <div class="container">
            <div class="jumbotron">
                <h2 align="center"  class="heading"> Word Board</h2>
            <br>
               ${msg} 
            <form name="f1" action="Javafile" method="get" class="form-horizontol">
                <table align="center">
                    
                    <tr>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    </tr>
                    <tr>
                        <td><input id="moreWords2" autofocus="" placeholder="Start Typing"/></td>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        
                    </tr>

                </table>
                <br><br>
                <textarea class='form-control' readonly="" id="enteredTextBox" placeholder="Feed Me Words.."></textarea> 
                <br>
                
            </form>
                <button class='btn btn-info' align='center' id='clearWord'>Kick Out</button>
                <div id="snackbar">Word Board is already Empty!!</div>
            </div>
        </div>    
    </body>
    <script src="jquery-1.8.3.min.js"></script>
    <script src="select2.min.js"></script>
    
        
    <script>
       $(document).ready(function(){
           $("#clearWord").click(function()
            {
               
                var word=document.getElementById("enteredTextBox").innerHTML;
                if(word=='' || word==' ')
                {
                    document.getElementById("enteredTextBox").innerHTML='';
                    showToast();
                }    
                else if(word!=undefined)
                {
                var lastIndex = word.lastIndexOf(" ");
                word = word.substring(0, lastIndex);
                document.getElementById("enteredTextBox").innerHTML=word;
                }
            });
            function showToast() {
                var x = document.getElementById("snackbar")
                x.className = "show";
                setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
            }
           
            jQuery("#moreWords2").select2({
                minimumInputLength: 1,
                allowClear:true,
                width: 'resolve',
                ajax: 
                        {
                        url: "Javafile",
                        dataType:"json",
                        data: function (term, page) {
                           term=term.toLowerCase();
                            return {
                                inputStr:term,
                                page:page
                            };
                         },
                     
                        results: function(data,page)
                        {
                            return{
                                results: data.matchedArrayJSON,
                                more: (page * 10) < data.totalFind
                                };
                        },
                        error: function(e){
                            alert('Error: ' + e);
                        }
                    
                }  
               
            });
            
    
            $("#moreWords2").change(function () {
                
                var selOption=$('#moreWords2').val();
                
                 document.getElementById("enteredTextBox").innerHTML+=" "+selOption;   
              });
    });
     
    </script>
    
</html>
