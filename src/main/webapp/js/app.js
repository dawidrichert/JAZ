$(document).ready(function () {

    $("#year").val((new Date).getFullYear());

    $("input[name=contractType]").click(function () {
        var contractType = $("input[name=contractType]:checked").val();
        var dues = $("#dues");
        var costs = $("#costs");

        if (contractType == 0) {
            dues.addClass("hidden");
            costs.addClass("hidden");
        } else if (contractType == 1) {
            dues.addClass("hidden");
            costs.removeClass("hidden");
        } else if (contractType == 2) {
            dues.removeClass("hidden");
            costs.removeClass("hidden");
        }
    });
});