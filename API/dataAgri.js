var obj1={
	"result":[{
		"grid":"1",
		"temp": "23.9",
		"pressure":"999.59",
		"moisture":"-7",
		"humidity":"56"
	},
	{
		"grid":"2",
		"temp": "24.2",
		"pressure":"999.00",
		"moisture":"-12",
		"humidity":"58"
	},
	{
		"grid":"3",
		"temp": "23.7",
		"pressure":"1000.2",
		"moisture":"-19",
		"humidity":"54"
	},
	{
		"grid":"4",
		"temp": "24.0",
		"pressure":"999.87",
		"moisture":"-28",
		"humidity":"53"
	},
	{
		"grid":"5",
		"temp": "23.8",
		"pressure":"999.94",
		"moisture":"-16",
		"humidity":"58"
	},
	{
		"grid":"6",
		"temp": "24.1",
		"pressure":"997.59",
		"moisture":"-48",
		"humidity":"57"
	},
	{
		"grid":"7",
		"temp": "22.9",
		"pressure":"986.59",
		"moisture":"-85",
		"humidity":"56"
	},
	{
		"grid":"8",
		"temp": "24.5",
		"pressure":"979.79",
		"moisture":"-150",
		"humidity":"53"
	},
	{
		"grid":"9",
		"temp": "24.3",
		"pressure":"998.59",
		"moisture":"-18",
		"humidity":"50"
	},
	{
		"grid":"10",
		"temp": "22.9",
		"pressure":"957.59",
		"moisture":"-26",
		"humidity":"45"
	}

	]
};


use agridb;
db.layouts.insert(obj1);
db.layouts.find().pretty();