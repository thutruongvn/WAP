"use strict";
var _accountInfoList = [];
const Module = (function() {
    const _addNewAccount = function(name, deposit) {
        _accountInfoList.push({
            accountName: name,
            deposit
        });
    };
    const addNewAccount = function() {
        let txtName = document.getElementById("txtAccountName");
        let txtDeposit = document.getElementById("numDeposit");
        _addNewAccount(txtName.value || "", txtDeposit.value || "");
        var txtResult = document.getElementById("txtaResult");
        var lstAccounts = _accountInfoList.map( (e, i, array)  => "Account name:" + e.accountName + " deposit:" + e.deposit );
        txtResult.value = lstAccounts.join("\n");
        txtName.value = "";
        txtDeposit.value = "";
    };

    return {
        addNewAccount: addNewAccount
    };
})();
window.onload = function () {
    var btnAdd = document.getElementById("btnCreateAcc");
    btnAdd.onclick = Module.addNewAccount;
    
    

}