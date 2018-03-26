var express = require('express');
var router  =express.Router();


var Crops=require('./agrischema');
Crops.methods(['get','put','post','delete']);

Crops.register(router,'/layout');


module.exports=router;
