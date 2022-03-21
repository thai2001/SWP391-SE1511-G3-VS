/*
 * Copyright(C) 2005, G3-VS.
 * Vehicle Store
 *  
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-10      1.0                 Thainv           First Implement
 */

const cardRows = [...document.querySelectorAll('.detail-card-row')]
console.log(cardRows)

showPeriod = (element) => {
    let cardRow = element.parentElement.parentElement.parentElement
    cardRow.getElementsByClassName('period')[0].classList.toggle('active');
}

let fromDateString = document.getElementsByName('from')[0].value
let toDateString = document.getElementsByName('to')[0].value
let today = new Date('2022-03-28');
let fromDate = new Date(fromDateString);
let toDate = new Date(toDateString)
console.log(toDate)
cardRows.forEach(element => {
    let cardRow = element;
    cardRow.getElementsByClassName('from')[0].textContent = fromDate.toDateString();
    cardRow.getElementsByClassName('to')[0].textContent = toDate.toDateString();
});
if (today >= fromDate && today < toDate) {
    try {
        cardRows.forEach(cardRow => {
            if (cardRow.getElementsByClassName('pay-btn')[0].dataset.paid === "false" && cardRow.getElementsByClassName('pay-btn')[0].dataset.cancel === "false") {
                cardRow.getElementsByClassName('pay-btn')[0].removeAttribute('hidden')
            }
            cardRow.getElementsByClassName('period-indicator')[1].classList.add('active')
            cardRow.getElementsByClassName('blink')[1].classList.add('active')
            cardRow.getElementsByClassName('cancel-btn')[0].setAttribute('hidden', '')
        });
    } catch (error) {
        console.error(error)
    }

}
if (today >= toDate) {
    try {
        cardRows.forEach(cardRow => {
            cardRow.getElementsByClassName('period-indicator')[1].classList.add('active')
            cardRow.getElementsByClassName('blink')[1].classList.add('active')
            cardRow.getElementsByClassName('period-indicator')[2].classList.add('active');
            cardRow.getElementsByClassName('blink')[2].classList.add('active');
                        cardRow.getElementsByClassName('cancel-btn')[0].setAttribute('hidden', '')
        });
    } catch (error) {
        console.error(error)
    }

}

confirmCancel = (element) => {
    let box = element.parentElement
    box.getElementsByClassName('cancel-btn')[0].classList.add('active')
    box.getElementsByClassName('yes')[0].classList.add('active')
    box.getElementsByClassName('no')[0].classList.add('active')

}

noCancel = (element) => {
    let box = element.parentElement
    box.getElementsByClassName('cancel-btn')[0].classList.remove('active')
    box.getElementsByClassName('yes')[0].classList.remove('active')
    box.getElementsByClassName('no')[0].classList.remove('active')
}







