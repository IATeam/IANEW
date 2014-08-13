/**
 * Created by Quang
 * 02/08/2014 
 */
 
 //keep search bar and status bar position fixed while scrolling
 //up and down
 $(document).ready(function(){
 	$(document).scroll(function(){
 		var scroll=$(this).scrollTop();
 		var topDist=$('#secSearch').position();
 		if(scroll>topDist.top){
 			$('#secSearch').css({'position':'fixed', 'top':'0'});
 		}else{
 			$('#secSearch').css({'position':'static','top':'auto'});
 		}
 	
 	});
 	
 	//search bar is greyed out unless on focus
 	//$('#dvSearchBox').blur()
 	
 });