/* 30個你必須記住的CSS選擇器 */
/* https://code.tutsplus.com/zh-hant/tutorials/the-30-css-selectors-you-must-memorize--net-16048 */

console.log('tablePage.js');

const tablePageDiv = document.getElementById('table-page-div');
const requestContextPath = tablePageDiv.requestContextPath;
const sendDataButtonObj = document.getElementById('send-data-button-id');
const clearCheckboxButtonObj = document.getElementById('clear-checkbox-button-id');
const allCheckboxObj = document.getElementById('all-checkbox-id');

console.log('requestContextPath = ', requestContextPath);

/* 當 【送出勾選資料】按鈕 按下去時會執行的程式 */
sendDataButtonObj.addEventListener('click', function () {

    /* 使用 CSS selector語法 去抓出已經被使用者勾選的 checkbox */
    const checkboxList = document.querySelectorAll("#customer-table-id > tbody input[type=checkbox]:checked");

    if (checkboxList.length === 0) {
        window.alert('請勾選要儲存的列數資料');
        return;
    }

    const dataArray = [];

    for (let i = 0, len = checkboxList.length; i < len; i++) {
        var unitObject = {};

        /* 抓出 tr DOM node */
        var trObj = checkboxList[i].parentElement.parentElement;

        /* 抓出 tr 底下的 td DOM node [編號][id] */
        var tdId = trObj.childNodes[3].textContent;

        /* 抓出 tr 底下的 td DOM node [伺服器][serverName] */
        var tdServerName = trObj.childNodes[5].childNodes[1].value;

        /* 抓出 tr 底下的 td DOM node [角色名稱][roleName] */
        var tdRoleName = trObj.childNodes[7].childNodes[1].value;

        /* 抓出 tr 底下的 td DOM node [Facebook名稱][facebookName] */
        var tdFacebookName = trObj.childNodes[9].childNodes[1].value;

        /* 抓出 tr 底下的 td DOM node [等級][level] */
        var tdLevel = trObj.childNodes[11].childNodes[1].value;

        unitObject.id = tdId;
        unitObject.serverName = tdServerName;
        unitObject.roleName = tdRoleName;
        unitObject.facebookName = tdFacebookName;
        unitObject.level = tdLevel;

        dataArray.push(unitObject);
    }

    console.log('dataArray = ', dataArray);

    /* 使用 AJAX技術 發送 POST請求 呼叫後端API， */
    /* 接著去接收後端API回傳給前端的資料。 */
    const xmlHttpRequest = new XMLHttpRequest();
    xmlHttpRequest.onreadystatechange = function () {
        if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
            const data = xmlHttpRequest.responseText;
            console.log('xmlHttpRequest data = ', data);
        }
    }
    xmlHttpRequest.open('post', requestContextPath + '/SaveData', true);
    xmlHttpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xmlHttpRequest.setRequestHeader('If-Modified-Since', '0');
    xmlHttpRequest.setRequestHeader('Pragma', 'no-cache');
    xmlHttpRequest.send(JSON.stringify(dataArray));
}, false);

/* 當 【清空checkbox】按鈕 按下去時會執行的程式 */
clearCheckboxButtonObj.addEventListener('click', function () {

    /* 把所有 checkbox 抓出來 */
    const checkboxList = document.querySelectorAll("#customer-table-id > tbody input[type=checkbox]");

    for (let i = 0, len = checkboxList.length; i < len; i++) {
        checkboxList[i].checked = false;
    }
    allCheckboxObj.checked = false;
}, false);

/* 當 標頭的checkbox 按下去時會執行的程式 */
allCheckboxObj.addEventListener('click', function () {

    /* 把所有 checkbox 抓出來 */
    const checkboxList = document.querySelectorAll("#customer-table-id > tbody input[type=checkbox]");

    let checkedFlag = null;

    if (allCheckboxObj.checked === true) {
        checkedFlag = true;
    } else {
        checkedFlag = false;
    }

    for (let i = 0, len = checkboxList.length; i < len; i++) {
        checkboxList[i].checked = checkedFlag;
    }
}, false);
