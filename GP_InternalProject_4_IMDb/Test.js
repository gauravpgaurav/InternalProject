var express = require('express');
var app = express();
app.use(express.static('public'));
// lets require/import the mongodb native drivers.
var mongodb = require('mongodb');

// We need to work with "MongoClient" interface in order to connect to a mongodb
// server.
var MongoClient = mongodb.MongoClient;

// Connection URL. This is where your mongodb server is running.
var url = 'mongodb://localhost:27017/internalDb4';

app.get('/', function(req, res) {
	res.sendfile('./views/index.html');
});

app.get("/MovieDetails", function(req, res) {

	MongoClient.connect(url, function(err, db) {

		var cursor = db.collection('moviecol').find().toArray(
				function(err, docs) {
					res.send(docs);
				});

	});
});

app.get('/ShowMovie/:id', function(req, res) {

	MongoClient.connect(url, function(err, db) {

		db.collection('moviecol').findOne({
			_id : parseInt(req.params.id)
		}, function(err, docs) {
			res.send(docs);
		});
	});
});

var server = app.listen(8083, function() {

	var host = server.address().address;
	var port = server.address().port;

	console.log("Example app listening at http://%s:%s", host, port);

});