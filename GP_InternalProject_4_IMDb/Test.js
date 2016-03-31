var express = require('express');
var app = express();

// lets require/import the mongodb native drivers.
var mongodb = require('mongodb');

// We need to work with "MongoClient" interface in order to connect to a mongodb
// server.
var MongoClient = mongodb.MongoClient;

// Connection URL. This is where your mongodb server is running.
var url = 'mongodb://localhost:27017/internalDb4';
/*
// Use connect method to connect to the Server
MongoClient
		.connect(
				url,
				function(err, db) {
					if (err) {
						console
								.log(
										'Unable to connect to the mongoDB server. Error:',
										err);
					} else {
						// HURRAY!! We are connected. :)
						console.log('Connection established to', url);

						// do some work here with the database.
						// Get the documents collection
						var collection = db.collection('moviecol');

						// Insert some users
						collection
								.find({
									_id : 101
								})
								.toArray(
										function(err, result) {
											var intCount = result.length;
											if (err) {
												console.log("Here!");
												console.log(err);
											} else if (result.length) {
												if (intCount > 0) {
													var strJson = "";
													var arrSongs = "";
													for (var i = 0; i < intCount;) {
														arrSongs = result[i].soundTrack;
														strJson += '{"soundTrack":"'
																+ result[i].soundTrack
																+ '"}'
														i = i + 1;
														if (i < intCount) {
															strJson += ',';
														}
													}

												}
												console
														.log(arrSongs[1].songName);
												console.log('Found:', result);
											} else {
												console
														.log('No document(s) found with defined "find" criteria!');
											}
											// Close connection
											db.close();
										});

					}

				});
*/
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