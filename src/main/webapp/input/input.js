var com = { qmino : { miredot : {}}};
com.qmino.miredot.restApiSource = {"licenceType":"FREE","projectVersion":"1.0-SNAPSHOT","allowUsageTracking":true,"licenceHash":"-8765605041121036235","licenceErrorMessage":null,"miredotVersion":"1.3","validLicence":true,"projectName":"ALDBackend Maven Webapp","dateOfGeneration":"2014-01-26 12:57:20"};
com.qmino.miredot.restApiSource.tos = {
	org_rest_service_entities_ArtCollection_in: { "type": "complex", "name": "org_rest_service_entities_ArtCollection_in", "content": [] },
	org_rest_service_entities_ArtCollection_out: { "type": "complex", "name": "org_rest_service_entities_ArtCollection_out", "content": [] },
	org_rest_service_entities_Dimensions_in: { "type": "complex", "name": "org_rest_service_entities_Dimensions_in", "content": [] },
	org_rest_service_entities_Dimensions_out: { "type": "complex", "name": "org_rest_service_entities_Dimensions_out", "content": [] },
	org_rest_service_entities_Artwork_in: { "type": "complex", "name": "org_rest_service_entities_Artwork_in", "content": [] },
	org_rest_service_entities_Artwork_out: { "type": "complex", "name": "org_rest_service_entities_Artwork_out", "content": [] },
	org_rest_service_entities_Artist_in: { "type": "complex", "name": "org_rest_service_entities_Artist_in", "content": [] },
	org_rest_service_entities_Artist_out: { "type": "complex", "name": "org_rest_service_entities_Artist_out", "content": [] },
	org_rest_service_entities_Comment_in: { "type": "complex", "name": "org_rest_service_entities_Comment_in", "content": [] },
	org_rest_service_entities_Comment_out: { "type": "complex", "name": "org_rest_service_entities_Comment_out", "content": [] }
};

com.qmino.miredot.restApiSource.enums = {
	org_rest_service_entities_TypesAndTechniques$ArtWorkType: { "type": "enum", "name": "org_rest_service_entities_TypesAndTechniques$ArtWorkType", "values": ["PAINTING", "DRAWING", "SCULPTURE", "PHOTO"]},
	org_rest_service_entities_TypesAndTechniques$Technique: { "type": "enum", "name": "org_rest_service_entities_TypesAndTechniques$Technique", "values": ["AQUARELLE", "GOUACHE", "PEINTURE_HUILE", "PEINTURE_EAU"]},
	org_rest_service_entities_TypesAndTechniques$Support: { "type": "enum", "name": "org_rest_service_entities_TypesAndTechniques$Support", "values": ["TOILE_DE_LIN", "COTON", "PAPIER", "CARTON", "BOIS", "CIRE", "ARGILE", "PLASTILINE", "CARTON_PATE", "PLATRE_ET_STUC", "STAFF", "CIMENT", "PIERRE"]}
};
com.qmino.miredot.restApiSource.tos["org_rest_service_entities_ArtCollection_in"].content = [ 
	{
		"name": "tags"	,
		"typeValue": { "type": "collection", "typeValue":{ "type": "simple", "typeValue": "string" } }
	},
	{
		"name": "artworks"	,
		"typeValue": { "type": "collection", "typeValue":com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Artwork_in"] }
	},
	{
		"name": "comments"	,
		"typeValue": { "type": "collection", "typeValue":com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Comment_in"] }}
];
com.qmino.miredot.restApiSource.tos["org_rest_service_entities_ArtCollection_out"].content = [ 
	{
		"name": "tags"	,
		"typeValue": { "type": "collection", "typeValue":{ "type": "simple", "typeValue": "string" } }
	},
	{
		"name": "artworks"	,
		"typeValue": { "type": "collection", "typeValue":com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Artwork_out"] }
	},
	{
		"name": "comments"	,
		"typeValue": { "type": "collection", "typeValue":com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Comment_out"] }}
];
com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Dimensions_in"].content = [ 
	{
		"name": "z"	,
		"typeValue": { "type": "simple", "typeValue": "number" }
	},
	{
		"name": "y"	,
		"typeValue": { "type": "simple", "typeValue": "number" }
	},
	{
		"name": "x"	,
		"typeValue": { "type": "simple", "typeValue": "number" }}
];
com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Dimensions_out"].content = [ 
	{
		"name": "z"	,
		"typeValue": { "type": "simple", "typeValue": "number" }
	},
	{
		"name": "y"	,
		"typeValue": { "type": "simple", "typeValue": "number" }
	},
	{
		"name": "x"	,
		"typeValue": { "type": "simple", "typeValue": "number" }}
];
com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Artwork_in"].content = [ 
	{
		"name": "id"	,
		"typeValue": { "type": "simple", "typeValue": "number" }
	},
	{
		"name": "exposed"	,
		"typeValue": { "type": "simple", "typeValue": "boolean" }
	},
	{
		"name": "technique"	,
		"typeValue": com.qmino.miredot.restApiSource.enums["org_rest_service_entities_TypesAndTechniques$Technique"]
	},
	{
		"name": "photos"	,
		"typeValue": { "type": "simple", "typeValue": "string" }
	},
	{
		"name": "tags"	,
		"typeValue": { "type": "collection", "typeValue":{ "type": "simple", "typeValue": "string" } }
	},
	{
		"name": "creationDate"	,
		"typeValue": { "type": "simple", "typeValue": "date string" }
	},
	{
		"name": "title"	,
		"typeValue": { "type": "simple", "typeValue": "string" }
	},
	{
		"name": "support"	,
		"typeValue": com.qmino.miredot.restApiSource.enums["org_rest_service_entities_TypesAndTechniques$Support"]
	},
	{
		"name": "description"	,
		"typeValue": { "type": "simple", "typeValue": "string" }
	},
	{
		"name": "dimensions"	,
		"typeValue": com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Dimensions_in"]
	},
	{
		"name": "type"	,
		"typeValue": com.qmino.miredot.restApiSource.enums["org_rest_service_entities_TypesAndTechniques$ArtWorkType"]
	},
	{
		"name": "artistName"	,
		"typeValue": { "type": "simple", "typeValue": "string" }
	},
	{
		"name": "comments"	,
		"typeValue": { "type": "collection", "typeValue":com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Comment_in"] }}
];
com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Artwork_out"].content = [ 
	{
		"name": "photos"	,
		"typeValue": { "type": "simple", "typeValue": "string" }
	},
	{
		"name": "technique"	,
		"typeValue": com.qmino.miredot.restApiSource.enums["org_rest_service_entities_TypesAndTechniques$Technique"]
	},
	{
		"name": "tags"	,
		"typeValue": { "type": "collection", "typeValue":{ "type": "simple", "typeValue": "string" } }
	},
	{
		"name": "exposed"	,
		"typeValue": { "type": "simple", "typeValue": "boolean" }
	},
	{
		"name": "id"	,
		"typeValue": { "type": "simple", "typeValue": "number" }
	},
	{
		"name": "creationDate"	,
		"typeValue": { "type": "simple", "typeValue": "date string" }
	},
	{
		"name": "title"	,
		"typeValue": { "type": "simple", "typeValue": "string" }
	},
	{
		"name": "support"	,
		"typeValue": com.qmino.miredot.restApiSource.enums["org_rest_service_entities_TypesAndTechniques$Support"]
	},
	{
		"name": "description"	,
		"typeValue": { "type": "simple", "typeValue": "string" }
	},
	{
		"name": "dimensions"	,
		"typeValue": com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Dimensions_out"]
	},
	{
		"name": "artistName"	,
		"typeValue": { "type": "simple", "typeValue": "string" }
	},
	{
		"name": "type"	,
		"typeValue": com.qmino.miredot.restApiSource.enums["org_rest_service_entities_TypesAndTechniques$ArtWorkType"]
	},
	{
		"name": "comments"	,
		"typeValue": { "type": "collection", "typeValue":com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Comment_out"] }}
];
com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Artist_in"].content = [ 
	{
		"name": "id"	,
		"typeValue": { "type": "simple", "typeValue": "number" }
	},
	{
		"name": "nationality"	,
		"typeValue": { "type": "simple", "typeValue": "string" }
	},
	{
		"name": "description"	,
		"typeValue": { "type": "simple", "typeValue": "string" }
	},
	{
		"name": "name"	,
		"typeValue": { "type": "simple", "typeValue": "string" }
	},
	{
		"name": "birthDate"	,
		"typeValue": { "type": "simple", "typeValue": "date string" }
	},
	{
		"name": "type"	,
		"typeValue": com.qmino.miredot.restApiSource.enums["org_rest_service_entities_TypesAndTechniques$ArtWorkType"]
	},
	{
		"name": "photo"	,
		"typeValue": { "type": "simple", "typeValue": "string" }
	},
	{
		"name": "city"	,
		"typeValue": { "type": "simple", "typeValue": "string" }}
];
com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Artist_out"].content = [ 
	{
		"name": "id"	,
		"typeValue": { "type": "simple", "typeValue": "number" }
	},
	{
		"name": "nationality"	,
		"typeValue": { "type": "simple", "typeValue": "string" }
	},
	{
		"name": "description"	,
		"typeValue": { "type": "simple", "typeValue": "string" }
	},
	{
		"name": "name"	,
		"typeValue": { "type": "simple", "typeValue": "string" }
	},
	{
		"name": "birthDate"	,
		"typeValue": { "type": "simple", "typeValue": "date string" }
	},
	{
		"name": "type"	,
		"typeValue": com.qmino.miredot.restApiSource.enums["org_rest_service_entities_TypesAndTechniques$ArtWorkType"]
	},
	{
		"name": "photo"	,
		"typeValue": { "type": "simple", "typeValue": "string" }
	},
	{
		"name": "city"	,
		"typeValue": { "type": "simple", "typeValue": "string" }}
];
com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Comment_in"].content = [ 
	{
		"name": "content"	,
		"typeValue": { "type": "simple", "typeValue": "string" }
	},
	{
		"name": "author"	,
		"typeValue": { "type": "simple", "typeValue": "string" }
	},
	{
		"name": "postDate"	,
		"typeValue": { "type": "simple", "typeValue": "date string" }}
];
com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Comment_out"].content = [ 
	{
		"name": "content"	,
		"typeValue": { "type": "simple", "typeValue": "string" }
	},
	{
		"name": "author"	,
		"typeValue": { "type": "simple", "typeValue": "string" }
	},
	{
		"name": "postDate"	,
		"typeValue": { "type": "simple", "typeValue": "date string" }}
];
com.qmino.miredot.restApiSource.interfaces = [
	{
		"beschrijving": "",
		"url": "/museum/artist/byNationality/{nationality}",
		"http": "GET",
		"title": null,
		"tags": [],
		"authors": [],
		"compressed": false,
		"deprecated": false,
		"consumes": [],
		"produces": ["application/json"],
		"roles": [],
		"output": {"typeValue": { "type": "collection", "typeValue":com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Artist_out"] }, "comment": null},
		"statusCodes": [],
		"hash": "-844859445",
		"inputs": {
                "PATH": [{"name": "nationality", "typeValue": { "type": "simple", "typeValue": "string" }, "comment": null, "jaxrs": "PATH"}],
                "QUERY": [],
                "BODY": [],
                "HEADER": [],
                "COOKIE": [],
                "FORM": [],
                "MATRIX": []
            }
	},
	{
		"beschrijving": "",
		"url": "/museum/artwork/get/bySupport/{support}",
		"http": "GET",
		"title": null,
		"tags": [],
		"authors": [],
		"compressed": false,
		"deprecated": false,
		"consumes": [],
		"produces": ["application/json"],
		"roles": [],
		"output": {"typeValue": { "type": "collection", "typeValue":com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Artwork_out"] }, "comment": null},
		"statusCodes": [],
		"hash": "738314060",
		"inputs": {
                "PATH": [{"name": "support", "typeValue": com.qmino.miredot.restApiSource.enums["org_rest_service_entities_TypesAndTechniques$Support"], "comment": null, "jaxrs": "PATH"}],
                "QUERY": [],
                "BODY": [],
                "HEADER": [],
                "COOKIE": [],
                "FORM": [],
                "MATRIX": []
            }
	},
	{
		"beschrijving": "",
		"url": "/museum/artist/all",
		"http": "GET",
		"title": null,
		"tags": [],
		"authors": [],
		"compressed": false,
		"deprecated": false,
		"consumes": [],
		"produces": ["application/json"],
		"roles": [],
		"output": {"typeValue": { "type": "collection", "typeValue":com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Artist_out"] }, "comment": null},
		"statusCodes": [],
		"hash": "1618502563",
		"inputs": {
                "PATH": [],
                "QUERY": [],
                "BODY": [],
                "HEADER": [],
                "COOKIE": [],
                "FORM": [],
                "MATRIX": []
            }
	},
	{
		"beschrijving": "",
		"url": "/museum/collection/create/byTag/{tag}",
		"http": "GET",
		"title": null,
		"tags": [],
		"authors": [],
		"compressed": false,
		"deprecated": false,
		"consumes": [],
		"produces": ["application/json"],
		"roles": [],
		"output": {"typeValue": com.qmino.miredot.restApiSource.tos["org_rest_service_entities_ArtCollection_out"], "comment": null},
		"statusCodes": [],
		"hash": "1320529575",
		"inputs": {
                "PATH": [{"name": "tag", "typeValue": { "type": "simple", "typeValue": "string" }, "comment": null, "jaxrs": "PATH"}],
                "QUERY": [],
                "BODY": [],
                "HEADER": [],
                "COOKIE": [],
                "FORM": [],
                "MATRIX": []
            }
	},
	{
		"beschrijving": "",
		"url": "/museum/artist/",
		"http": "POST",
		"title": null,
		"tags": [],
		"authors": [],
		"compressed": false,
		"deprecated": false,
		"consumes": ["application/json"],
		"produces": [],
		"roles": [],
		"output": {"typeValue": { "type": "simple", "typeValue": "???" }, "comment": null},
		"statusCodes": [],
		"hash": "-1182639499",
		"inputs": {
                "PATH": [],
                "QUERY": [],
                "BODY": [{"typeValue": com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Artist_in"], "comment": null, "jaxrs": "BODY"}],
                "HEADER": [],
                "COOKIE": [],
                "FORM": [],
                "MATRIX": []
            }
	},
	{
		"beschrijving": "",
		"url": "/museum/artist/byCity/{city}",
		"http": "GET",
		"title": null,
		"tags": [],
		"authors": [],
		"compressed": false,
		"deprecated": false,
		"consumes": [],
		"produces": ["application/json"],
		"roles": [],
		"output": {"typeValue": { "type": "collection", "typeValue":com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Artist_out"] }, "comment": null},
		"statusCodes": [],
		"hash": "-63469210",
		"inputs": {
                "PATH": [{"name": "city", "typeValue": { "type": "simple", "typeValue": "string" }, "comment": null, "jaxrs": "PATH"}],
                "QUERY": [],
                "BODY": [],
                "HEADER": [],
                "COOKIE": [],
                "FORM": [],
                "MATRIX": []
            }
	},
	{
		"beschrijving": "",
		"url": "/museum/collection/",
		"http": "PUT",
		"title": null,
		"tags": [],
		"authors": [],
		"compressed": false,
		"deprecated": false,
		"consumes": ["application/json"],
		"produces": [],
		"roles": [],
		"output": {"typeValue": { "type": "simple", "typeValue": "???" }, "comment": null},
		"statusCodes": [],
		"hash": "-1853433553",
		"inputs": {
                "PATH": [],
                "QUERY": [],
                "BODY": [{"typeValue": com.qmino.miredot.restApiSource.tos["org_rest_service_entities_ArtCollection_in"], "comment": null, "jaxrs": "BODY"}],
                "HEADER": [],
                "COOKIE": [],
                "FORM": [],
                "MATRIX": []
            }
	},
	{
		"beschrijving": "",
		"url": "/museum/artwork/addComment/{id}",
		"http": "PUT",
		"title": null,
		"tags": [],
		"authors": [],
		"compressed": false,
		"deprecated": false,
		"consumes": ["application/json"],
		"produces": [],
		"roles": [],
		"output": {"typeValue": { "type": "simple", "typeValue": "???" }, "comment": null},
		"statusCodes": [],
		"hash": "273400469",
		"inputs": {
                "PATH": [{"name": "id", "typeValue": { "type": "simple", "typeValue": "number" }, "comment": null, "jaxrs": "PATH"}],
                "QUERY": [],
                "BODY": [{"typeValue": com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Comment_in"], "comment": null, "jaxrs": "BODY"}],
                "HEADER": [],
                "COOKIE": [],
                "FORM": [],
                "MATRIX": []
            }
	},
	{
		"beschrijving": "",
		"url": "/museum/artwork/get/byTechnique/{technique}",
		"http": "GET",
		"title": null,
		"tags": [],
		"authors": [],
		"compressed": false,
		"deprecated": false,
		"consumes": [],
		"produces": ["application/json"],
		"roles": [],
		"output": {"typeValue": { "type": "collection", "typeValue":com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Artwork_out"] }, "comment": null},
		"statusCodes": [],
		"hash": "-413930354",
		"inputs": {
                "PATH": [{"name": "technique", "typeValue": com.qmino.miredot.restApiSource.enums["org_rest_service_entities_TypesAndTechniques$Technique"], "comment": null, "jaxrs": "PATH"}],
                "QUERY": [],
                "BODY": [],
                "HEADER": [],
                "COOKIE": [],
                "FORM": [],
                "MATRIX": []
            }
	},
	{
		"beschrijving": "",
		"url": "/museum/artwork/get/byArtist/{artistName}",
		"http": "GET",
		"title": null,
		"tags": [],
		"authors": [],
		"compressed": false,
		"deprecated": false,
		"consumes": [],
		"produces": ["application/json"],
		"roles": [],
		"output": {"typeValue": { "type": "collection", "typeValue":com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Artwork_out"] }, "comment": null},
		"statusCodes": [],
		"hash": "-1031256363",
		"inputs": {
                "PATH": [{"name": "artistName", "typeValue": { "type": "simple", "typeValue": "string" }, "comment": null, "jaxrs": "PATH"}],
                "QUERY": [],
                "BODY": [],
                "HEADER": [],
                "COOKIE": [],
                "FORM": [],
                "MATRIX": []
            }
	},
	{
		"beschrijving": "",
		"url": "/museum/artwork/get/byTag/{tag}",
		"http": "GET",
		"title": null,
		"tags": [],
		"authors": [],
		"compressed": false,
		"deprecated": false,
		"consumes": [],
		"produces": ["application/json"],
		"roles": [],
		"output": {"typeValue": { "type": "collection", "typeValue":com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Artwork_out"] }, "comment": null},
		"statusCodes": [],
		"hash": "1709464438",
		"inputs": {
                "PATH": [{"name": "tag", "typeValue": { "type": "simple", "typeValue": "string" }, "comment": null, "jaxrs": "PATH"}],
                "QUERY": [],
                "BODY": [],
                "HEADER": [],
                "COOKIE": [],
                "FORM": [],
                "MATRIX": []
            }
	},
	{
		"beschrijving": "",
		"url": "/museum/collection/create",
		"http": "POST",
		"title": null,
		"tags": [],
		"authors": [],
		"compressed": false,
		"deprecated": false,
		"consumes": ["application/json"],
		"produces": ["application/json"],
		"roles": [],
		"output": {"typeValue": com.qmino.miredot.restApiSource.tos["org_rest_service_entities_ArtCollection_out"], "comment": null},
		"statusCodes": [],
		"hash": "229814337",
		"inputs": {
                "PATH": [],
                "QUERY": [],
                "BODY": [{"typeValue": { "type": "collection", "typeValue":com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Artwork_in"] }, "comment": null, "jaxrs": "BODY"}],
                "HEADER": [],
                "COOKIE": [],
                "FORM": [],
                "MATRIX": []
            }
	},
	{
		"beschrijving": "",
		"url": "/museum/artwork/represented",
		"http": "GET",
		"title": null,
		"tags": [],
		"authors": [],
		"compressed": false,
		"deprecated": false,
		"consumes": [],
		"produces": ["application/json"],
		"roles": [],
		"output": {"typeValue": { "type": "collection", "typeValue":com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Artwork_out"] }, "comment": null},
		"statusCodes": [],
		"hash": "-1392721101",
		"inputs": {
                "PATH": [],
                "QUERY": [],
                "BODY": [],
                "HEADER": [],
                "COOKIE": [],
                "FORM": [],
                "MATRIX": []
            }
	},
	{
		"beschrijving": "",
		"url": "/museum/collection/create/byArtist/{artistName}",
		"http": "GET",
		"title": null,
		"tags": [],
		"authors": [],
		"compressed": false,
		"deprecated": false,
		"consumes": [],
		"produces": ["application/json"],
		"roles": [],
		"output": {"typeValue": com.qmino.miredot.restApiSource.tos["org_rest_service_entities_ArtCollection_out"], "comment": null},
		"statusCodes": [],
		"hash": "32004612",
		"inputs": {
                "PATH": [{"name": "artistName", "typeValue": { "type": "simple", "typeValue": "string" }, "comment": null, "jaxrs": "PATH"}],
                "QUERY": [],
                "BODY": [],
                "HEADER": [],
                "COOKIE": [],
                "FORM": [],
                "MATRIX": []
            }
	},
	{
		"beschrijving": "",
		"url": "/museum/artwork/{id}",
		"http": "DELETE",
		"title": null,
		"tags": [],
		"authors": [],
		"compressed": false,
		"deprecated": false,
		"consumes": [],
		"produces": [],
		"roles": [],
		"output": {"typeValue": { "type": "simple", "typeValue": "???" }, "comment": null},
		"statusCodes": [],
		"hash": "-1418082743",
		"inputs": {
                "PATH": [{"name": "id", "typeValue": { "type": "simple", "typeValue": "number" }, "comment": null, "jaxrs": "PATH"}],
                "QUERY": [],
                "BODY": [],
                "HEADER": [],
                "COOKIE": [],
                "FORM": [],
                "MATRIX": []
            }
	},
	{
		"beschrijving": "",
		"url": "/museum/artwork/{id}",
		"http": "PUT",
		"title": null,
		"tags": [],
		"authors": [],
		"compressed": false,
		"deprecated": false,
		"consumes": ["application/json"],
		"produces": [],
		"roles": [],
		"output": {"typeValue": { "type": "simple", "typeValue": "???" }, "comment": null},
		"statusCodes": [],
		"hash": "937203208",
		"inputs": {
                "PATH": [],
                "QUERY": [],
                "BODY": [{"typeValue": com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Artwork_in"], "comment": null, "jaxrs": "BODY"}],
                "HEADER": [],
                "COOKIE": [],
                "FORM": [],
                "MATRIX": []
            }
	},
	{
		"beschrijving": "",
		"url": "/museum/artwork/{id}",
		"http": "GET",
		"title": null,
		"tags": [],
		"authors": [],
		"compressed": false,
		"deprecated": false,
		"consumes": [],
		"produces": ["application/json"],
		"roles": [],
		"output": {"typeValue": com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Artwork_out"], "comment": null},
		"statusCodes": [],
		"hash": "-1716737316",
		"inputs": {
                "PATH": [{"name": "id", "typeValue": { "type": "simple", "typeValue": "number" }, "comment": null, "jaxrs": "PATH"}],
                "QUERY": [],
                "BODY": [],
                "HEADER": [],
                "COOKIE": [],
                "FORM": [],
                "MATRIX": []
            }
	},
	{
		"beschrijving": "",
		"url": "/museum/artist/listByName/{name}",
		"http": "GET",
		"title": null,
		"tags": [],
		"authors": [],
		"compressed": false,
		"deprecated": false,
		"consumes": [],
		"produces": ["application/json"],
		"roles": [],
		"output": {"typeValue": { "type": "collection", "typeValue":com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Artist_out"] }, "comment": null},
		"statusCodes": [],
		"hash": "1764406596",
		"inputs": {
                "PATH": [{"name": "name", "typeValue": { "type": "simple", "typeValue": "string" }, "comment": null, "jaxrs": "PATH"}],
                "QUERY": [],
                "BODY": [],
                "HEADER": [],
                "COOKIE": [],
                "FORM": [],
                "MATRIX": []
            }
	},
	{
		"beschrijving": "",
		"url": "/museum/artist/{id}",
		"http": "GET",
		"title": null,
		"tags": [],
		"authors": [],
		"compressed": false,
		"deprecated": false,
		"consumes": [],
		"produces": ["application/json"],
		"roles": [],
		"output": {"typeValue": com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Artist_out"], "comment": null},
		"statusCodes": [],
		"hash": "-408467426",
		"inputs": {
                "PATH": [{"name": "id", "typeValue": { "type": "simple", "typeValue": "number" }, "comment": null, "jaxrs": "PATH"}],
                "QUERY": [],
                "BODY": [],
                "HEADER": [],
                "COOKIE": [],
                "FORM": [],
                "MATRIX": []
            }
	},
	{
		"beschrijving": "",
		"url": "/museum/artist/byName/{name}",
		"http": "GET",
		"title": null,
		"tags": [],
		"authors": [],
		"compressed": false,
		"deprecated": false,
		"consumes": [],
		"produces": ["application/json"],
		"roles": [],
		"output": {"typeValue": com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Artist_out"], "comment": null},
		"statusCodes": [],
		"hash": "-711579002",
		"inputs": {
                "PATH": [{"name": "name", "typeValue": { "type": "simple", "typeValue": "string" }, "comment": null, "jaxrs": "PATH"}],
                "QUERY": [],
                "BODY": [],
                "HEADER": [],
                "COOKIE": [],
                "FORM": [],
                "MATRIX": []
            }
	},
	{
		"beschrijving": "",
		"url": "/museum/artwork/",
		"http": "POST",
		"title": null,
		"tags": [],
		"authors": [],
		"compressed": false,
		"deprecated": false,
		"consumes": ["application/json"],
		"produces": [],
		"roles": [],
		"output": {"typeValue": { "type": "simple", "typeValue": "???" }, "comment": null},
		"statusCodes": [],
		"hash": "-1995010630",
		"inputs": {
                "PATH": [],
                "QUERY": [],
                "BODY": [{"typeValue": com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Artwork_in"], "comment": null, "jaxrs": "BODY"}],
                "HEADER": [],
                "COOKIE": [],
                "FORM": [],
                "MATRIX": []
            }
	},
	{
		"beschrijving": "",
		"url": "/museum/artwork/get/all",
		"http": "GET",
		"title": null,
		"tags": [],
		"authors": [],
		"compressed": false,
		"deprecated": false,
		"consumes": [],
		"produces": ["application/json"],
		"roles": [],
		"output": {"typeValue": { "type": "collection", "typeValue":com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Artwork_out"] }, "comment": null},
		"statusCodes": [],
		"hash": "454353421",
		"inputs": {
                "PATH": [],
                "QUERY": [],
                "BODY": [],
                "HEADER": [],
                "COOKIE": [],
                "FORM": [],
                "MATRIX": []
            }
	},
	{
		"beschrijving": "",
		"url": "/museum/artwork/get/byType/{type}",
		"http": "GET",
		"title": null,
		"tags": [],
		"authors": [],
		"compressed": false,
		"deprecated": false,
		"consumes": [],
		"produces": ["application/json"],
		"roles": [],
		"output": {"typeValue": { "type": "collection", "typeValue":com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Artwork_out"] }, "comment": null},
		"statusCodes": [],
		"hash": "117567048",
		"inputs": {
                "PATH": [{"name": "type", "typeValue": com.qmino.miredot.restApiSource.enums["org_rest_service_entities_TypesAndTechniques$ArtWorkType"], "comment": null, "jaxrs": "PATH"}],
                "QUERY": [],
                "BODY": [],
                "HEADER": [],
                "COOKIE": [],
                "FORM": [],
                "MATRIX": []
            }
	},
	{
		"beschrijving": "",
		"url": "/museum/artist/{id}",
		"http": "DELETE",
		"title": null,
		"tags": [],
		"authors": [],
		"compressed": false,
		"deprecated": false,
		"consumes": [],
		"produces": [],
		"roles": [],
		"output": {"typeValue": { "type": "simple", "typeValue": "???" }, "comment": null},
		"statusCodes": [],
		"hash": "-1335739425",
		"inputs": {
                "PATH": [{"name": "id", "typeValue": { "type": "simple", "typeValue": "number" }, "comment": null, "jaxrs": "PATH"}],
                "QUERY": [],
                "BODY": [],
                "HEADER": [],
                "COOKIE": [],
                "FORM": [],
                "MATRIX": []
            }
	},
	{
		"beschrijving": "",
		"url": "/museum/artist/represented",
		"http": "GET",
		"title": null,
		"tags": [],
		"authors": [],
		"compressed": false,
		"deprecated": false,
		"consumes": [],
		"produces": ["application/json"],
		"roles": [],
		"output": {"typeValue": { "type": "collection", "typeValue":com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Artist_out"] }, "comment": null},
		"statusCodes": [],
		"hash": "453939389",
		"inputs": {
                "PATH": [],
                "QUERY": [],
                "BODY": [],
                "HEADER": [],
                "COOKIE": [],
                "FORM": [],
                "MATRIX": []
            }
	},
	{
		"beschrijving": "",
		"url": "/museum/collection/{id}",
		"http": "DELETE",
		"title": null,
		"tags": [],
		"authors": [],
		"compressed": false,
		"deprecated": false,
		"consumes": [],
		"produces": [],
		"roles": [],
		"output": {"typeValue": { "type": "simple", "typeValue": "???" }, "comment": null},
		"statusCodes": [],
		"hash": "353929215",
		"inputs": {
                "PATH": [{"name": "id", "typeValue": { "type": "simple", "typeValue": "number" }, "comment": null, "jaxrs": "PATH"}],
                "QUERY": [],
                "BODY": [],
                "HEADER": [],
                "COOKIE": [],
                "FORM": [],
                "MATRIX": []
            }
	},
	{
		"beschrijving": "",
		"url": "/museum/artist/{id}",
		"http": "PUT",
		"title": null,
		"tags": [],
		"authors": [],
		"compressed": false,
		"deprecated": false,
		"consumes": ["application/json"],
		"produces": [],
		"roles": [],
		"output": {"typeValue": { "type": "simple", "typeValue": "???" }, "comment": null},
		"statusCodes": [],
		"hash": "-1879896487",
		"inputs": {
                "PATH": [],
                "QUERY": [],
                "BODY": [{"typeValue": com.qmino.miredot.restApiSource.tos["org_rest_service_entities_Artist_in"], "comment": null, "jaxrs": "BODY"}],
                "HEADER": [],
                "COOKIE": [],
                "FORM": [],
                "MATRIX": []
            }
	},
	{
		"beschrijving": "",
		"url": "/museum/collection/create/byTechnique/{technique}",
		"http": "GET",
		"title": null,
		"tags": [],
		"authors": [],
		"compressed": false,
		"deprecated": false,
		"consumes": [],
		"produces": ["application/json"],
		"roles": [],
		"output": {"typeValue": com.qmino.miredot.restApiSource.tos["org_rest_service_entities_ArtCollection_out"], "comment": null},
		"statusCodes": [],
		"hash": "1383725631",
		"inputs": {
                "PATH": [{"name": "technique", "typeValue": com.qmino.miredot.restApiSource.enums["org_rest_service_entities_TypesAndTechniques$Technique"], "comment": null, "jaxrs": "PATH"}],
                "QUERY": [],
                "BODY": [],
                "HEADER": [],
                "COOKIE": [],
                "FORM": [],
                "MATRIX": []
            }
	}];
com.qmino.miredot.projectWarnings = [
	{
		"category": "JAVADOC_MISSING_SUMMARY",
		"description": "Missing summary tag",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_INTERFACEDOCUMENTATION",
		"description": "Missing interface documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing parameter documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing return type documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_AUTHORS",
		"description": "No author(s) specified for interface.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_SUMMARY",
		"description": "Missing summary tag",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_INTERFACEDOCUMENTATION",
		"description": "Missing interface documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing parameter documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing return type documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_AUTHORS",
		"description": "No author(s) specified for interface.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_SUMMARY",
		"description": "Missing summary tag",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_INTERFACEDOCUMENTATION",
		"description": "Missing interface documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing return type documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_AUTHORS",
		"description": "No author(s) specified for interface.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_SUMMARY",
		"description": "Missing summary tag",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_INTERFACEDOCUMENTATION",
		"description": "Missing interface documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing parameter documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing return type documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_AUTHORS",
		"description": "No author(s) specified for interface.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_SUMMARY",
		"description": "Missing summary tag",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_INTERFACEDOCUMENTATION",
		"description": "Missing interface documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing parameter documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing return type documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_AUTHORS",
		"description": "No author(s) specified for interface.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAXRS_MISSING_PRODUCES",
		"description": "Interface returns a result, but does not specify a Produces value.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_SUMMARY",
		"description": "Missing summary tag",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_INTERFACEDOCUMENTATION",
		"description": "Missing interface documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing parameter documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing return type documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_AUTHORS",
		"description": "No author(s) specified for interface.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_SUMMARY",
		"description": "Missing summary tag",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_INTERFACEDOCUMENTATION",
		"description": "Missing interface documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing parameter documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing return type documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_AUTHORS",
		"description": "No author(s) specified for interface.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAXRS_MISSING_PRODUCES",
		"description": "Interface returns a result, but does not specify a Produces value.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_SUMMARY",
		"description": "Missing summary tag",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_INTERFACEDOCUMENTATION",
		"description": "Missing interface documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing parameter documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing parameter documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing return type documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_AUTHORS",
		"description": "No author(s) specified for interface.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAXRS_MISSING_PRODUCES",
		"description": "Interface returns a result, but does not specify a Produces value.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_SUMMARY",
		"description": "Missing summary tag",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_INTERFACEDOCUMENTATION",
		"description": "Missing interface documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing parameter documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing return type documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_AUTHORS",
		"description": "No author(s) specified for interface.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_SUMMARY",
		"description": "Missing summary tag",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_INTERFACEDOCUMENTATION",
		"description": "Missing interface documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing parameter documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing return type documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_AUTHORS",
		"description": "No author(s) specified for interface.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_SUMMARY",
		"description": "Missing summary tag",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_INTERFACEDOCUMENTATION",
		"description": "Missing interface documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing parameter documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing return type documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_AUTHORS",
		"description": "No author(s) specified for interface.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_SUMMARY",
		"description": "Missing summary tag",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_INTERFACEDOCUMENTATION",
		"description": "Missing interface documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing parameter documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing return type documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_AUTHORS",
		"description": "No author(s) specified for interface.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_SUMMARY",
		"description": "Missing summary tag",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_INTERFACEDOCUMENTATION",
		"description": "Missing interface documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing return type documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_AUTHORS",
		"description": "No author(s) specified for interface.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_SUMMARY",
		"description": "Missing summary tag",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_INTERFACEDOCUMENTATION",
		"description": "Missing interface documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing parameter documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing return type documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_AUTHORS",
		"description": "No author(s) specified for interface.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_SUMMARY",
		"description": "Missing summary tag",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_INTERFACEDOCUMENTATION",
		"description": "Missing interface documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing parameter documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing return type documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_AUTHORS",
		"description": "No author(s) specified for interface.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAXRS_MISSING_PRODUCES",
		"description": "Interface returns a result, but does not specify a Produces value.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_SUMMARY",
		"description": "Missing summary tag",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_INTERFACEDOCUMENTATION",
		"description": "Missing interface documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing parameter documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing return type documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_AUTHORS",
		"description": "No author(s) specified for interface.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAXRS_MISSING_PRODUCES",
		"description": "Interface returns a result, but does not specify a Produces value.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_SUMMARY",
		"description": "Missing summary tag",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_INTERFACEDOCUMENTATION",
		"description": "Missing interface documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing parameter documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing return type documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_AUTHORS",
		"description": "No author(s) specified for interface.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_SUMMARY",
		"description": "Missing summary tag",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_INTERFACEDOCUMENTATION",
		"description": "Missing interface documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing parameter documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing return type documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_AUTHORS",
		"description": "No author(s) specified for interface.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_SUMMARY",
		"description": "Missing summary tag",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_INTERFACEDOCUMENTATION",
		"description": "Missing interface documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing parameter documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing return type documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_AUTHORS",
		"description": "No author(s) specified for interface.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_SUMMARY",
		"description": "Missing summary tag",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_INTERFACEDOCUMENTATION",
		"description": "Missing interface documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing parameter documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing return type documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_AUTHORS",
		"description": "No author(s) specified for interface.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_SUMMARY",
		"description": "Missing summary tag",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_INTERFACEDOCUMENTATION",
		"description": "Missing interface documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing parameter documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing return type documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_AUTHORS",
		"description": "No author(s) specified for interface.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAXRS_MISSING_PRODUCES",
		"description": "Interface returns a result, but does not specify a Produces value.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_SUMMARY",
		"description": "Missing summary tag",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_INTERFACEDOCUMENTATION",
		"description": "Missing interface documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing return type documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_AUTHORS",
		"description": "No author(s) specified for interface.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_SUMMARY",
		"description": "Missing summary tag",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_INTERFACEDOCUMENTATION",
		"description": "Missing interface documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing parameter documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing return type documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_AUTHORS",
		"description": "No author(s) specified for interface.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_SUMMARY",
		"description": "Missing summary tag",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_INTERFACEDOCUMENTATION",
		"description": "Missing interface documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing parameter documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing return type documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_AUTHORS",
		"description": "No author(s) specified for interface.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAXRS_MISSING_PRODUCES",
		"description": "Interface returns a result, but does not specify a Produces value.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_SUMMARY",
		"description": "Missing summary tag",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_INTERFACEDOCUMENTATION",
		"description": "Missing interface documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing return type documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_AUTHORS",
		"description": "No author(s) specified for interface.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_SUMMARY",
		"description": "Missing summary tag",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_INTERFACEDOCUMENTATION",
		"description": "Missing interface documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing parameter documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing return type documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_AUTHORS",
		"description": "No author(s) specified for interface.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAXRS_MISSING_PRODUCES",
		"description": "Interface returns a result, but does not specify a Produces value.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_SUMMARY",
		"description": "Missing summary tag",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_INTERFACEDOCUMENTATION",
		"description": "Missing interface documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing parameter documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing return type documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_AUTHORS",
		"description": "No author(s) specified for interface.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAXRS_MISSING_PRODUCES",
		"description": "Interface returns a result, but does not specify a Produces value.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_SUMMARY",
		"description": "Missing summary tag",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_INTERFACEDOCUMENTATION",
		"description": "Missing interface documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing parameter documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_PARAMETER_DOCUMENTATION",
		"description": "Missing return type documentation",
		"failedBuild": false,
		"interface": null,
		"entity": null
	},
	{
		"category": "JAVADOC_MISSING_AUTHORS",
		"description": "No author(s) specified for interface.",
		"failedBuild": false,
		"interface": null,
		"entity": null
	}];
com.qmino.miredot.processErrors  = [
];

