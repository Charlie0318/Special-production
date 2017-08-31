typedef struct
{
	/** The eyecatcher for this structure.  Must be MQTS */
	const char struct_id[3];
	/** The version number of this structure.  Must be 0 */
	int struct_version;

	
	const unsigned char* pub_key;


	const unsigned char* priv_key;

	
	const unsigned char* policy;
	
	int security;
	
	int dosomething;
	/** to dosomething*/
} MQTTClient_BeeOptions;
#define MQTTClient_BeeOptions_initializer { {'B', 'E', 'E'}, 0, NULL, NULL, NULL,0,0}
