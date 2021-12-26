export default function contentdisplay(){
    if(!localStorage.getItem("username")){
        return false;
    }else{
        return true;
    }
}