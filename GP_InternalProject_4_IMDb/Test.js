//lets require/import the mongodb native drivers.
var mongodb = require('mongodb');

// We need to work with "MongoClient" interface in order to connect to a mongodb
// server.
var MongoClient = mongodb.MongoClient;

// Connection URL. This is where your mongodb server is running.
var url = 'mongodb://localhost:27017/internalDb4';

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
											if (err) {
												console.log("Here!");
												console.log(err);
											} else if (result.length) {
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