/*
 * Eledux 1.0.0
 * MIT License
 * Copyright 2016, Niki Skaarup
*/

$ = function (input, multiple) {
    if(multiple === undefined)
        multiple = false;

    if(input.length < 1)
        return undefined;

    var selector = input.substring(0,1);
    // Select by Id
    if(selector === '#')
        return document.getElementById(input.substring(1));

    // Select by Class
    if(selector === '.')
        return document.getElementsByClassName(input.substring(1));

    // Select by querySelector(All).
    if(multiple)
       return document.querySelectorAll(input);
    
    return document.querySelector(input);
};
