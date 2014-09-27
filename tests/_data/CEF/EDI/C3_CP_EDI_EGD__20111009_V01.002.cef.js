var a1 = [
    { type:"global-attr", key:"FILE_NAME", value:"C3_CP_EDI_EGD__20111009_V01.cef" },

    { type:"global-attr", key:"FILE_FORMAT_VERSION", value:"CEF-2.0" },
    
    { type:"meta-attr", name:"LOGICAL_FILE_ID",
      attrs:[ 
            { type:"meta-attr", key:"ENTRY", value:"C3_CP_EDI_EGD__20111009_V01" },
        ],
    },
    
    { type:"meta-attr", name:"VERSION_NUMBER",
        attrs:[ 
            { type:"meta-attr", key:"ENTRY", value:"01" },
        ],
    },
     
    { type:"meta-attr", name:"FILE_TIME_SPAN",
        attrs:[ 
            { type:"meta-attr", key:"VALUE_TYPE", value:"ISO_TIME_RANGE", type:"" },
            { type:"meta-attr", key:"ENTRY", value:"2011-10-09T00:00:00Z/2011-10-10T00:00:00Z", type:"" },
        ],
    },
     
    { type:"meta-attr", name:"FILE_TIME_SPAN",
        attrs:[ 
            { type:"meta-attr", key:"VALUE_TYPE", value:"ISO_TIME_RANGE", type:"" },
            { type:"meta-attr", key:"ENTRY", value:"2011-10-09T00:00:00Z/2011-10-10T00:00:00Z", type:"" },
        ],
    },
     
    { type:"meta-attr", name:"GENERATION_DATE",
        attrs:[ 
            { type:"meta-attr", key:"VALUE_TYPE", value:"ISO_TIME", type:"" },
            { type:"meta-attr", key:"ENTRY", value:"2012-04-11T15:57:15Z", type:"" },
        ],
    },
     
    // include EGD (DATASET) HEADER File for Cluster-3" 
    // with variable definitions, metadata_type and _version" 
     
    { type:"global-attr", key:"include", value:"C3_CH_EDI_EGD_DATASET" },
     
    { type:"global-attr", key:"DATA_UNTIL", value:"EOF" },
];

