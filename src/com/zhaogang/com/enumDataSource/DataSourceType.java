package com.zhaogang.com.enumDataSource;

public enum DataSourceType implements IEnum {

	
	ERP_DATA_SOURCE(1,"ERP","erpOracleDataConnection",1),
	FIN_DATA_SOURCE(2,"FIN","finOracleDataConnection",1),
	FIN_ODS_DATA_SOURCE(3,"FIN_ODS","finOdsOracleDataConnection",1),
	FIN_DW_DATA_SOURCE(4,"FIN_DW","finDwOracleDataConnection",1),
	FIN_DM_DATA_SOURCE(5,"FIN_DM","finDmOracleDataConnection",1),
	PMBT_DATA_SOURCE(6,"PMBT","pmbtOracleDataConnection",1),
	CONT_DATA_SOURCE(7,"CONT","contOracleDataConnection",1),
	XINXH_DATA_SOURCE(8,"XINXH","xinxhMySqlDataConnection",2),//信息化
    CREDIT_DATA_SOURCE(9,"CREDIT","creditOracleDataConnection",1),
    GSS_DATA_SOURCE(10,"GSS","gssMySqlDataConnection",2),
    WP_DATA_SOURCE(11,"WP_OMS","wpMySqlDataConnection",2),//委托加工
    PORTAL_DATA_SOURCE(12,"ZG_PORTAL","portalMySqlDataConnection",2),//portal
    CUOHE_DATA_SOURCE(13,"CUOHE","cuoheOracleDataConnection",1),//普碳
    WORKFLOW_DATA_SOURCE(14,"WORKFLOW","workflowMySqlDataConnection",2),//工作流
    WULIU_DATA_SOURCE(15,"WULIU","wuliuOracleDataConnection",1),//物流
    LGFIN_DATA_SOURCE(16,"LG_FINANCE","lgfinMySqlDataConnection",2),//物流财务
    YUNCANG_DATA_SOURCE(17,"WP_YUNCANG","yuncangMySqlDataConnection",2),//三方仓储
    CRM_DATA_SOURCE(18,"INTEREST_CRM","crmOracleDataConnection",1),//金融CRM
    BILL_DATA_SOURCE(19,"BILL","billOracleDataConnection",1),//票据业务平台
    DC_DATA_SOURCE(20,"DATA_PLATFORM","dcOracleDataConnection",1),//数据中心
    NOTE_DATA_SOURCE(21,"NOTE","noteOracleDataConnection",1),//银票系统
    INTERST_DATA_SOURCE(22,"FIN_INTERST","interstOracleDataConnection",1),//供应链金融
	PMSYT_DATA_SOURCE(23,"PMSYT","pmsytOracleDataConnection",1);
	
	private Integer value;
	private String name;
	private String springAliasName;
	private Integer dataType;//1.oracle  2.MySql
	
	private DataSourceType(Integer value,String name,String springAliasName,Integer dataType){
		this.value=value;
		this.name=name;
		this.springAliasName=springAliasName;
		this.dataType=dataType;
	}
	
	@Override
	public Integer getValue() {		
		return this.value;
	}

	@Override
	public String getName() {		
		return this.name();
	}

	@Override
	public IEnum getEnumByVal(Integer val) {
		return EnumsUtil.getEnumByVal(val, DataSourceType.values());
	}

	@Override
	public String getEnumToStr() {
		return EnumsUtil.getEnumToJsonStr(DataSourceType.values());
	}

	public static DataSourceType getSourceTypeById(Integer id){
		if(id==null){
			return null;
		}
		DataSourceType result=null;
		for (DataSourceType x : DataSourceType.values()) {
			if(id.equals(x.getValue())){
				result=x;
				break;
			}
		}
		return result;
	}
}
