var express = require('express');
var router = express.Router();
var {Post} = require('../models/Post');

var post_controller = require('../post_controller/post_controller');

router.post('/add',post_controller.add);
router.get('/profile', post_controller.profile);
router.get('/',(req,res)=>{
    res.render('index');
});

module.exports=router;