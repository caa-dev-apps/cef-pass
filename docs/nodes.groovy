root() {
  a(FILE_NAME:'C3_CP_EDI_EGD__20111009_V01.cef', q:true)
  a(FILE_FORMAT_VERSION:'CEF-2.0', q:true)
  c('!')
  meta(name:'LOGICAL_FILE_ID') {
    a(ENTRY:'C3_CP_EDI_EGD__20111009_V01', q:true)
  }
  c('!')
  meta(name:'VERSION_NUMBER') {
    a(ENTRY:'01', q:true)
  }
  c('!')
  meta(name:'FILE_TIME_SPAN') {
    a(VALUE_TYPE:'ISO_TIME_RANGE', q:false)
    a(ENTRY:'2011-10-09T00:00:00Z/2011-10-10T00:00:00Z', q:false)
  }
  c('!')
  meta(name:'GENERATION_DATE') {
    a(VALUE_TYPE:'ISO_TIME', q:false)
    a(ENTRY:'2012-04-11T15:57:15Z', q:false)
  }
  c('!')
  meta(name:'FILE_CAVEATS') {
    a(ENTRY:'CAA_EDITOF_V1_04  2011-04-04T10:30:00Z', q:true)
  }
  c('!')
  c('! include EGD (DATASET) HEADER File for Cluster-3')
  c('! with variable definitions, metadata_type and _version')
  a(include:'C3_CH_EDI_EGD_DATASET.ceh', q:true)
  c('! EGD (DATASET) HEADER File for Cluster C3')
  c('! TO BE WRITTEN into each EGD-file:  *.cef')
  c('!include INSTRUMENT HEADER file and implicitly MISSION, OBS, EXP headers')
  a(include:'C3_CH_EDI3_INST.ceh', q:true)
  c('!------------------- INSTR HEADER FILE EDI3 --------------------')
  c('! INCLUDE OBSERVATORY and EXPERIMENT HEADER FILE')
  c('!EXPERIMENT HEADER FILE contains MISSION HEADER')
  a(include:'CL_CH_EDI_EXP.ceh', q:true)
  c('!------------------- EXPERIMENT HEADER FILE--------------------')
  c('! INCLUDE MISSION HEADER FILE')
  a(include:'CL_CH_MISSION.ceh', q:true)
  c('!')
  c('!  CL_CH_MISSION.ceh')
  c('!  Global mission metadata provided by the CAA.')
  c('!')
  c('!  Save to your own hard drive so this file can be')
  c('!  included as CL_CH_MISSION.ceh in other cef files. ')
  c('! ')
  meta(name:'MISSION') {
    a(ENTRY:'Cluster', q:true)
  }
  meta(name:'MISSION_TIME_SPAN') {
    a(VALUE_TYPE:'ISO_TIME_RANGE', q:false)
    a(ENTRY:'2000-08-16T12:39:00Z/2009-12-31T23:59:59Z', q:false)
  }
  meta(name:'MISSION_AGENCY') {
    a(ENTRY:'ESA', q:true)
  }
  meta(name:'MISSION_DESCRIPTION') {
    a(ENTRY:'The aim of the Cluster mission is to study small-scale structures of the magnetosphere ', q:true)
    a(ENTRY:'and its environment in three dimensions. To achieve this, Cluster is constituted of four ', q:true)
    a(ENTRY:'identical spacecraft that will flight in a tetrahedral configuration. The separation distances ', q:true)
    a(ENTRY:'between the spacecraft will be varied between ~40 km and 10 000 km, according to the ', q:true)
    a(ENTRY:'key scientific regions.', q:true)
  }
  meta(name:'MISSION_KEY_PERSONNEL') {
    a(ENTRY:'Philippe Escoubet>Philippe.Escoubet@esa.int >Cluster Project Scientist', q:true)
  }
  meta(name:'MISSION_REFERENCES') {
    a(ENTRY:'The Cluster and Phoenix Missions>Cluster project and instrument teams>Space Sci. Rev. 79, Nos. 1-2, 1997', q:true)
  }
  meta(name:'MISSION_REGION') {
    a(ENTRY:'Solar_Wind', q:true)
    a(ENTRY:'Bow_Shock', q:true)
    a(ENTRY:'Magnetosheath', q:true)
    a(ENTRY:'Magnetopause', q:true)
    a(ENTRY:'Magnetosphere', q:true)
    a(ENTRY:'Magnetotail', q:true)
    a(ENTRY:'Polar_Cap', q:true)
    a(ENTRY:'Auroral_Region', q:true)
    a(ENTRY:'Cusp', q:true)
    a(ENTRY:'Radiation_Belt', q:true)
    a(ENTRY:'Plasmasphere', q:true)
  }
  meta(name:'MISSION_CAVEATS') {
    a(ENTRY:'*CL', q:true)
  }
  c('!')
  meta(name:'EXPERIMENT') {
    a(ENTRY:'EDI', q:true)
  }
  c('!')
  meta(name:'EXPERIMENT_DESCRIPTION') {
    a(ENTRY:'Electron Drift Instrument', q:true)
    a(ENTRY:'Electric field measured by the drift velocity ', q:true)
    a(ENTRY:'of monoenergetic artificial electron beams ', q:true)
    a(ENTRY:'injected perpendicularly to the ambient magnetic field', q:true)
  }
  c('!')
  meta(name:'INVESTIGATOR_COORDINATES') {
    a(ENTRY:'Goetz Paschmann>PI>goetz.paschmann@mpe.mpg.de', q:true)
    a(ENTRY:'Roy Torbert>PI>roy.torbert@unh.edu', q:true)
    a(ENTRY:'Jack Quinn>CoPI>jmquinn@bu.edu', q:true)
  }
  c('!')
  meta(name:'EXPERIMENT_REFERENCES') {
    a(ENTRY:'*CL_CD_EDI_CAAICD', q:true)
    a(ENTRY:'*CL_CD_EDI_USERMAN', q:true)
    a(ENTRY:'AnnGeo_FirstResults.pdf', q:true)
    a(ENTRY:'AnnGeo_JQuinn1669.pdf', q:true)
    a(ENTRY:'http://www.mpe.mpg.de/CLUSTER/EDI-Pages/edi_page.html', q:true)
  }
  c('!')
  meta(name:'EXPERIMENT_KEY_PERSONNEL') {
    a(ENTRY:'Edita Georgescu>Archive Scientist>eg@mps.mpg.de', q:true)
    a(ENTRY:'Hans Vaith>Experiment Engineer>hans.vaith@unh.edu', q:true)
    a(ENTRY:'Mark Chutter>Software Engineer>mark.chutter@unh.edu', q:true)
    a(ENTRY:'Pamela Puhl-Quinn>Software Engineer>pamela.puhlquinn@aer.com', q:true)
  }
  c('!')
  meta(name:'EXPERIMENT_CAVEATS') {
    a(ENTRY:'EDI experiment is operated in 2 modes 'Electric Field'', q:true)
    a(ENTRY:'and 'Ambient Electron' mode, see CaveatList files for', q:true)
    a(ENTRY:'specific time intervals', q:true)
    a(ENTRY:'""', q:false)
    a(ENTRY:'Large data gaps may occur due to: ', q:true)
    a(ENTRY:'- highly variable magnetic and/or electric fields', q:true)
    a(ENTRY:'- high ambient electron fluxes', q:true)
    a(ENTRY:'- radiation induced hardware failures', q:true)
    a(ENTRY:'""', q:false)
    a(ENTRY:'Smaller data gaps occur in MCP calibration mode or ', q:true)
    a(ENTRY:'at regularly scheduled BM3 dumps', q:true)
    a(ENTRY:'""', q:false)
    a(ENTRY:'Data availability in 'Electric field' mode is documented', q:true)
    a(ENTRY:'in the QSTAT files with 10 min resolution', q:true)
    a(ENTRY:'""', q:false)
  }
  a(include:'C3_CH_OBS.ceh', q:true)
  c('!')
  c('!  C3_CH_OBS.ceh')
  c('!  Global Cluster3 metadata provided by the CAA.')
  c('!')
  c('! Save to your own hard drive so this file can be')
  c('! included as C3_CH_OBS.ceh in other cef files. ')
  c('! ')
  meta(name:'OBSERVATORY') {
    a(ENTRY:'Cluster-3', q:true)
  }
  meta(name:'OBSERVATORY_CAVEATS') {
    a(ENTRY:'*C3_CQ', q:true)
  }
  meta(name:'OBSERVATORY_DESCRIPTION') {
    a(ENTRY:'Cluster-3 (Samba)', q:true)
    a(ENTRY:'Launched: 16 Jul 2000', q:true)
    a(ENTRY:'ESA Number: 3', q:true)
    a(ENTRY:'COSPAR ID: 2000-041A', q:true)
    a(ENTRY:'USSPACECOM catalogue number: 26410', q:true)
    a(ENTRY:'CSDS Code: C3', q:true)
    a(ENTRY:'ESOC FD code: S3', q:true)
    a(ENTRY:'ESA Flight Model Number: FM7', q:true)
  }
  meta(name:'OBSERVATORY_TIME_SPAN') {
    a(VALUE_TYPE:'ISO_TIME_RANGE', q:false)
    a(ENTRY:'2000-07-16T12:39:00Z/2009-12-31T23:59:59Z', q:false)
  }
  meta(name:'OBSERVATORY_REGION') {
    a(ENTRY:'Solar_Wind', q:true)
    a(ENTRY:'Bow_Shock', q:true)
    a(ENTRY:'Magnetosheath', q:true)
    a(ENTRY:'Magnetopause', q:true)
    a(ENTRY:'Magnetosphere', q:true)
    a(ENTRY:'Magnetotail', q:true)
    a(ENTRY:'Polar_Cap', q:true)
    a(ENTRY:'Auroral_Region', q:true)
    a(ENTRY:'Cusp', q:true)
    a(ENTRY:'Radiation_Belt', q:true)
    a(ENTRY:'Plasmasphere', q:true)
  }
  c('!')
  meta(name:'INSTRUMENT_NAME') {
    a(ENTRY:'EDI3', q:true)
  }
  c('!')
  meta(name:'INSTRUMENT_DESCRIPTION') {
    a(ENTRY:'EDI Experiment on Cluster C3', q:true)
  }
  c('!')
  meta(name:'INSTRUMENT_TYPE') {
    a(ENTRY:'Electron_Drift', q:true)
  }
  c('!')
  meta(name:'MEASUREMENT_TYPE') {
    a(ENTRY:'Electric_Field', q:true)
  }
  c('!')
  meta(name:'INSTRUMENT_CAVEATS') {
    a(ENTRY:' ', q:true)
  }
  c('!')
  meta(name:'DATASET_ID') {
    a(ENTRY:'C3_CP_EDI_EGD', q:true)
  }
  c('!')
  meta(name:'DATA_TYPE') {
    a(ENTRY:'CP>CAA Parameter', q:true)
  }
  c('!')
  meta(name:'DATASET_TITLE') {
    a(ENTRY:'Electron Gyrotime Data', q:true)
  }
  c('!')
  meta(name:'DATASET_DESCRIPTION') {
    a(ENTRY:'This dataset contains measurements of the gyro-time of emitted ', q:true)
    a(ENTRY:'electrons from the EDI experiment on the Cluster C3 spacecraft', q:true)
    a(ENTRY:'The kinetic energy of the emitted electrons is: 1. or 0.5 keV (kine_flag=0,1) ', q:true)
  }
  c('!')
  meta(name:'CONTACT_COORDINATES') {
    a(ENTRY:'EditaGeorgescu>Archive Scientist>eg@mps.mpg.de', q:true)
  }
  c('!')
  meta(name:'PROCESSING_LEVEL') {
    a(ENTRY:'Auxiliary', q:true)
  }
  c('!')
  meta(name:'TIME_RESOLUTION') {
    a(ENTRY:'0.015625', q:false)
  }
  c('!')
  meta(name:'MAX_TIME_RESOLUTION') {
    a(ENTRY:'0.015625', q:false)
  }
  c('!')
  meta(name:'MIN_TIME_RESOLUTION') {
    a(ENTRY:'1.e31', q:false)
  }
  c('!')
  meta(name:'DATASET_CAVEATS') {
    a(ENTRY:'No regularly spaced time series!', q:true)
    a(ENTRY:'MAX_TIME_RESOLUTION is given for burst mode', q:true)
    a(ENTRY:'MIN_TIME_RESOLUTION is set to fill_value', q:true)
    a(ENTRY:'Time_tags are the registered UT at electron detection', q:true)
    a(ENTRY:'To convert gyrotime microseconds to B in nT use for', q:true)
    a(ENTRY:'kine_flag=0: 35793.785', q:true)
    a(ENTRY:'kine_flag=1: 35758.831', q:true)
    a(ENTRY:'""', q:false)
  }
  c('!')
  meta(name:'ACKNOWLEDGEMENT') {
    a(ENTRY:'Please acknowledge the EDI team and ESA Cluster Active Archive', q:true)
    a(ENTRY:' when using this data', q:true)
  }
  c('!')
  meta(name:'METADATA_TYPE') {
    a(ENTRY:'CAA', q:true)
  }
  c('!')
  meta(name:'METADATA_VERSION') {
    a(ENTRY:'2.0', q:true)
  }
  c('!')
  meta(name:'FILE_TYPE') {
    a(ENTRY:'cef', q:true)
  }
  c('!')
  meta(name:'DATASET_VERSION') {
    a(ENTRY:'2.0', q:true)
  }
  c('!')
  var(name:'time_tags__C3_CP_EDI_EGD') {
    a(PARAMETER_TYPE:'Support_Data', q:true)
    a(CATDESC:'Time Tag', q:true)
    a(UNITS:'s', q:true)
    a(SI_CONVERSION:'1.0>s', q:true)
    a(FIELDNAM:'Universal Time', q:true)
    a(FILLVAL:'9999-12-31T23:59:59.999999Z', q:false)
    a(SIGNIFICANT_DIGITS:'27', q:false)
    a(LABLAXIS:'UT', q:true)
    a(VALUE_TYPE:'ISO_TIME', q:false)
    a(DELTA_PLUS:'0.244e-6', q:false)
    a(DELTA_MINUS:'0.244e-6', q:false)
  }
  c('!')
  var(name:'tof__C3_CP_EDI_EGD') {
    a(PARAMETER_TYPE:'Data', q:true)
    a(ENTITY:'Electron', q:true)
    a(PROPERTY:'Time-of-Flight', q:true)
    a(CATDESC:'electron gyration time', q:true)
    a(VALUE_TYPE:'FLOAT', q:false)
    a(FIELDNAM:'Time-of-Flight', q:true)
    a(FILLVAL:'0.000', q:false)
    a(SIGNIFICANT_DIGITS:'10', q:false)
    a(QUALITY:'2', q:true)
    a(LABLAXIS:'tof', q:true)
    a(SI_CONVERSION:'1.0e-6>s', q:true)
    a(UNITS:'microseconds', q:true)
    a(DEPEND_0:'time_tags__C3_CP_EDI_EGD', q:false)
  }
  c('!')
  var(name:'sigma_tof__C3_CP_EDI_EGD') {
    a(PARAMETER_TYPE:'Data', q:true)
    a(ENTITY:'Electron', q:true)
    a(PROPERTY:'Time-of-Flight', q:true)
    a(CATDESC:'electron gyration time standard deviation', q:true)
    a(VALUE_TYPE:'FLOAT', q:false)
    a(FIELDNAM:'Time-of-Flight standard deviation', q:true)
    a(FILLVAL:'0.000', q:false)
    a(SIGNIFICANT_DIGITS:'10', q:false)
    a(QUALITY:'2', q:true)
    a(LABLAXIS:'sigma_tof', q:true)
    a(SI_CONVERSION:'1.0e-6>s', q:true)
    a(UNITS:'microseconds', q:true)
    a(DEPEND_0:'time_tags__C3_CP_EDI_EGD', q:false)
  }
  c('!')
  var(name:'gdu_flag__C3_CP_EDI_EGD') {
    a(PARAMETER_TYPE:'Support_Data', q:true)
    a(ENTITY:'Electron', q:true)
    a(PROPERTY:'Time-of-Flight', q:true)
    a(CATDESC:'Detector Unit', q:true)
    a(VALUE_TYPE:'INT', q:false)
    a(FIELDNAM:'Detector Unit', q:true)
    a(FILLVAL:'0', q:false)
    a(SIGNIFICANT_DIGITS:'1', q:false)
    a(LABLAXIS:'DU', q:true)
    a(UNITS:'Unitless', q:true)
    a(DEPEND_0:'time_tags__C3_CP_EDI_EGD', q:false)
  }
  c('!')
  var(name:'kine_flag__C3_CP_EDI_EGD') {
    a(PARAMETER_TYPE:'Support_Data', q:true)
    a(ENTITY:'Electron', q:true)
    a(PROPERTY:'Time-of-Flight', q:true)
    a(CATDESC:'electron gyration time', q:true)
    a(VALUE_TYPE:'INT', q:false)
    a(FIELDNAM:'Kinetic Energy Flag', q:true)
    a(FILLVAL:'9', q:false)
    a(SIGNIFICANT_DIGITS:'1', q:false)
    a(LABLAXIS:'KinEnFlag', q:true)
    a(UNITS:'Unitless', q:true)
    a(DEPEND_0:'time_tags__C3_CP_EDI_EGD', q:false)
  }
  c('!')
  a(DATA_UNTIL:'EOF', q:false)
}

