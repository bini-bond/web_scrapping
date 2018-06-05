var mongoose = require('mongoose');
mongoose.connect('mongodb://localhost:27017/news');
mongoose.Promise = global.Promise;
module.exports = {mongoose};


