var express = require('express');
var mongoose = require('mongoose');
var bodyparser = require('body-parser');
var url = require('url');
//https://github.com/account
mongoose.connect('mongodb://localhost/agridb');
var app = express();

app.use(bodyparser.urlencoded({extended:true}));
app.use(bodyparser.json());

//Routes


app.use('/field',require('./agrirouter'));

//Start server 
app.listen(1337,"0.0.0.0",function() {
	console.log('Listening at port 1337');
});
