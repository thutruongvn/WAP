"use strict";

function BicycleFC() {
        this.speed = 0;
    this.applyBrake = function (decrement) { 
        this.speed -= decrement;
    }
    this.speedup = function (increment) { 
        this.speed += increment;
    }
}
function MountainBikeFC (proto) {
    this.__proto__ = proto;
    this.gearSet = 1;
    this.setGear = function(gear) { 
        this.gearSet = gear; 
    };
}
    const startTestFC = function() {
        let bicyclePrototype = new BicycleFC();
        let mountainBikePrototype = new MountainBikeFC(bicyclePrototype);
        console.log("mountainBikePrototype before play");
        console.log("mountainBikePrototype.speed = " + mountainBikePrototype.speed);
        console.log("mountainBikePrototype.gearSet = " + mountainBikePrototype.gearSet);
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
