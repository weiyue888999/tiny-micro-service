<html>
    <head>
        <title>Hello,world</title>
        <script src="/js/jquery-3.5.1.min.js"></script>
    </head>
    <body>
        <div>
            Hello,world.111
        </div>
        <script>
            function refresh(){
                $.ajax({
                            type:"GET",
                            url:"myServlet",
                            dataType:"json",
                            success:function(data){
                                console.log(data);
                                refresh();
                            },
                            error:function(jqXHR){
                                console.log("Error: "+jqXHR.status);
                                refresh();
                            }
                        });
            }

            $(function(){
                //refresh();
            });
        </script>
    </body>
</html>