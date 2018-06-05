var { Post } = require('../models/Post');



exports.add = (req, res) => {
    var title = req.body.title;
    
    console.log(req.body);

    var content = req.body.content;
    post = new Post({ Title: title, Content: content});
    post.save();
    res.send(post);
};

exports.profile =  (req, res) => {
    Post.find().sort({ $natural: 1 }).limit(15).then((data)=>{
                res.send(data);
    },()=>{

    });    
};