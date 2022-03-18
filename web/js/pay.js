/*
 * Copyright(C) 2005, G3-VS.
 * Vehicle Store
 *  
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-10      1.0                 Thainv           First Implement
 */

const cardRows = [...document.querySelectorAll('.shopping-card-row')];

document.getElementsByClassName('nop')[0].textContent = cardRows.length;
var totalPrice = 0;
let today = new Date();
let fromDate = new Date();
let toDate = new Date();
fromDate.setDate(today.getDate() + 7);
toDate.setDate(fromDate.getDate() + 7);
let todayString = today.getFullYear() + "-" + (today.getMonth() < 10 ? '0' + (today.getMonth() + 1) : (today.getMonth() + 1)) + "-" + (today.getDate() < 10 ? '0' + today.getDate() : today.getDate())
let fromDateString = fromDate.getFullYear() + "-" + (fromDate.getMonth() < 10 ? '0' + (fromDate.getMonth() + 1) : (fromDate.getMonth() + 1)) + "-" + (fromDate.getDate() < 10 ? '0' + fromDate.getDate() : fromDate.getDate())
let toDateString = toDate.getFullYear() + "-" + (toDate.getMonth() < 10 ? '0' + (toDate.getMonth() + 1) : (toDate.getMonth() + 1)) + "-" + (toDate.getDate() < 10 ? '0' + toDate.getDate() : toDate.getDate())
console.log(fromDateString);
console.log(fromDate.toDateString());
cardRows.forEach(element => {
    let cardRow = element;
    let cardTotal = parseFloat(cardRow.getElementsByClassName('card-total')[0].textContent.replace('$', ""));
    totalPrice += cardTotal;
    cardRow.getElementsByClassName('from')[0].textContent = fromDate.toDateString();
    cardRow.getElementsByClassName('to')[0].textContent = toDate.toDateString();
});
let fromInputs = document.getElementsByName('from');
for (let i = 0; i < fromInputs.length; i++) {
    fromInputs[i].value = fromDateString;
}
let toInputs = document.getElementsByName('to');
for (let i = 0; i < toInputs.length; i++) {
    toInputs[i].value = toDateString;
}
console.log(document.getElementsByName('from'));
document.getElementsByClassName('totalPrice')[0].innerHTML = totalPrice + " $ ";
document.getElementsByName('total')[0].value = totalPrice;
document.getElementsByName('today')[0].value = todayString;





