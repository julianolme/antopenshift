var app = angular.module("app", ['ngRoute', 'ui.date']);

app.constant('uiDateConfig', {
    dateFormat: "dd-mm-yy",
    dayNamesMin: ["Do", "Lu", "Ma", "Mi", "Ju", "Vi", "Sa"],
    firstDay: 1,
    monthNames: ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"],
    defaultDate: new Date,
    maxDate: new Date,
    showWeek: true,
    weekHeader: "Sm"
});

