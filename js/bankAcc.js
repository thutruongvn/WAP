"use strict"
var accountInfoList = [];
const Module = (function() {
    const _addNewAccount = function(name, deposit) {
        accountInfoList.push({
            accountName: name,
            deposit
        });
    };
    const addNewAccount = function(name, deposit) {
        _addNewAccount(name, deposit);
    };

    return {
        addNewAccount: addNewAccount
    };
})();
var btnAdd = document.getElementById("btnCreateAcc");
btnAdd.onclick = Module.addNewAccount;
var txtResult = document.getElementById("txtaResult");
txtResult.innerText = accountInfoList.forEach( e => "Account name:" + e.accountName + " deposit:" + e.deposit);

