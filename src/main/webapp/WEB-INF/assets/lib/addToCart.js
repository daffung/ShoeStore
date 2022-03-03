/**
 * 
 */
 $(document).ready(function(){

    $('.add-to-cart').on('click', function() {
        var pID = this.id;
        
        console.log(pID);
        $.ajax({
            url: "/DemoShopping/addToCart",
            type:"POST",
            dataType:"text",
            data:{
                pID:pID,
                quantity:1
            }
        }).done(function(string){
            
            console.log("success post");
            //console.log(string.split(" ").pop())
            $(".cart-quantity").text(string.split(" ").pop())
            //console.log($(".cart-quantity").text())
        }).fail(function(){
            console.log("Fail");
        })
        
    });
    
});