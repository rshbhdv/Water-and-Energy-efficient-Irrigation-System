var restful = require('node-restful');
var mongoose = restful.mongoose;

var agriSchema = new mongoose.Schema({
	result:[{
		grid:String,
		temp: String,
		pressure: String,
		moisture: String,
		humidity: String
	}]
});
module.exports = restful.model('Layout',agriSchema); 