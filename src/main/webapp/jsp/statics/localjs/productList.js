$(function () {
    //轮播图
    var left = 0;
    var step = 600;
    var eq = 0;
    $(".lunbo>div>p>span").click(function () {
        eq = $(this).index();
        $(this).css("background","#62B1F4").siblings().css("background","#ffffff");
        if (eq ==0){
            left = 0;
        }else {
            left = -step*eq;
        }
        $(".lunbo>ul").animate({"left":left});
    });
    var timeID = setInterval(function () {
        eq++;
        if(eq >=5){
            eq = 0;
        }
        left -= step;
        if (left<=-step*5){
            left=0;
        }
        $(".lunbo>ul").animate({"left":left});
        $(".lunbo>div>p>span:eq("+eq+")").css("background","#62B1F4").siblings().css("background","#ffffff");
    },5000)
})