/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function setInitialFocus(componentId){
    return document.getElementById(componentId).focus();
}
function setReadOnlyDate() {
    var images = document.getElementsByTagName('img');
    for (i = 0; i < images.length; i++) {
        if(images[i].onclick!=null){
            var onclickProperty=images[i].onclick.toString();
            if (onclickProperty.indexOf('getPosition')>=0 ||onclickProperty.indexOf('displayCalendar')>=0) {
                var quote = /"/;
                var element =  onclickProperty.split(quote)[1];
                document.getElementById(element).readOnly = true;
            }
        }
    }
}
function deletedColor(tableId, trSize){
    var rowsLength = document.getElementById('form1:'+tableId+'').getElementsByTagName('tr').length;
    for(var i=0;i<rowsLength-trSize;i++){
        var component='form1:'+tableId.concat(':').concat(i);
        if(document.getElementById(component).className.indexOf('iceRowSelSelected')>=0){
            document.getElementById(component).style.background= '#f1c8c8';
        }
    }

}