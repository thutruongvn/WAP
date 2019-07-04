"use strict";

const moduleBicycle = (function() {

    const createBicyclePrototype = function() {
        return {
            speed: 0,
            applyBrake: function (decrement) { this.speed -= decrement;},
            speedup: function (increment) { this.speed += increment;}
        }
    };
    const createMountainBikePrototype = function(prototype) {
        let obj = Object.create(prototype);
        obj.gearSet = 1;
        obj.setGear = function(gear) { this.gearSet = gear; }
        return obj;
    };
    const start = function() {
        let bicyclePrototype = createBicyclePrototype();
        let mountainBikePrototype = createMountainBikePrototype(bicyclePrototype);
        console.log("mountainBikePrototype before play");
        console.log("mountainBikePrototype.speed = " +mountainBikePrototype.speed);
        console.log("mountainBikePrototype.gearSet = " +mountainBikePrototype.gearSet);
        mountainBikePrototype.setGear(5);
        mountainBikePrototype.speedup(10);
        mountainBikePrototype.applyBrake(1);
        console.log("mountainBikePrototype after play");
        console.log(mountainBikePrototype);
    
        // Now create some objects from both bicyclePrototype and mountainBikePrototype
        let obj1 = Object.create(bicyclePrototype);
        let obj2 = Object.create(mountainBikePrototype);
        console.log("obj1 which is derived from bicyclePrototype");
        console.log("obj1.speed = " +obj1.speed);
        console.log(`obj1.speedup(5);
obj1.applyBrake(1);`);
        obj1.speedup(5);
        obj1.applyBrake(1);
        // obj1.setGear(5); // will cause error: obj1.setGear is not a function
        console.log(obj1);

        console.log("obj2 which is derived from mountainBikePrototype");
        console.log("obj2.speed = " +obj2.speed);
        console.log("obj2.gearSet = " +obj2.gearSet);
        console.log(`obj2.speedup(8);
obj2.applyBrake(4);
obj2.setGear(3);`);
        obj2.speedup(8);
        obj2.applyBrake(4);
        obj2.setGear(3);
        console.log(obj2);
    };
    return {
        createBicyclePrototype: createBicyclePrototype,
        createMountainBikePrototype: createMountainBikePrototype,
        start: start
    };
})();
window.onload = function() {
    const btnCreate = document.getElementById("btnCreateBikeMod");
    btnCreate.onclick = moduleBicycle.start;
    const btnES6 = document.getElementById("btnCreateBikeES6");
    btnES6.onclick = startTestES6;
    const btnFC = document.getElementById("btnCreateBikeFC");
    btnFC.onclick = startTestFC;

    const btnQ2 = document.getElementById("btnQ7Q2");
    btnQ2.onclick = function(){
        console.log(`
        let module = (function(){ 
            x=10; 
            let outer1="outer1"; 
            function f1(arg1, arg2){ 
                let func1 = function(){ return arg2;}; 
            } 
            return outer1; 
        })(); 
        alert(module); 
        alert(x); `);
        console.log("a. How many global variables we have? One (x = 10)");
        console.log("b. Are there any closures in the code? One (x = 10)Closure (f1) arg2: 'outer1'");
        console.log("c. What will be the outputs of the code?  alert >> module = 'outer1' and x = 10");
        console.log(`d. How will you call function f1 from outside the module? 
There is no way to access f1 from outside module unless module return f1 function as an attribute function`);
    };
    const btnQ4 = document.getElementById("btnQ7Q4");
    btnQ4.onclick =  function(){
        console.log(`
        (function(x,y){    
            "use strict";    
            console.log(this); 
            console.log(x,y); 
            const obj = {
                x:2, 
                foo:function(){
                    console.log(this.x)
                }
            };    
            obj.foo(); 
 
            obj.bar = () =>console.log(this.x);    
            obj.bar(); 
        })(5,7);  `);
        console.log("why this is undefined? because of 'use strict' inside the function, this would not refer to window and be 'undefined'. Therefore, arrow function could not get x from undefined.");
    };
}
