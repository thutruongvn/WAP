"use strict";
let accountInfoList = [];
const Module = (function () {
    const _addNewAccount = function (name, deposit) {
        accountInfoList.push({
            accountName: name,
            deposit
        });
    };
    const addNewAccount = function () {
        let txtName = document.getElementById("txtAccountName");
        let txtDeposit = document.getElementById("numDeposit");
        _addNewAccount(txtName.value || "", txtDeposit.value || "");
        const txtResult = document.getElementById("txtaResult");
        const lstAccounts = accountInfoList.map((e, i, array) => {
            return "Account name:" + e.accountName + " deposit:" + e.deposit;
        });
        txtResult.value = lstAccounts.join("\n");
        txtName.value = "";
        txtDeposit.value = "";
    };

    return {
        addNewAccount: addNewAccount
    };
})();
window.onload = function () {
    const btnAdd = document.getElementById("btnCreateAcc");
    btnAdd.onclick = Module.addNewAccount;
}