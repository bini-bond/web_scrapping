var mongoose = require('mongoose');
var PostSchema = new mongoose.Schema({

    Title: {
        type: String,
        required: true
    },

    Content:{
        type:String
    },

    
    

});


var Post = mongoose.model("Post", PostSchema);

module.exports = { Post };



























