
hitsArray=new Array();

$.ajax({
    type:'GET',
    url:'/image/search',
    success:function(response){
      hitsArray=response[0].hits;
   
      for(let i=0; i<hitsArray.length; i++){
        $('.img-fluid').eq(i).attr('src',hitsArray[i].webformatURL);
            
      }
     
    }
})

