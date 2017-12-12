package com.zhaogang.com.mybaits;

import java.util.Date;

public class BaseModel {
	
	/**
	  * 新增人ID
	  */
	 public long addedBy;
	 
	 /**
	  * 新增人名字
	  */
	 public String addedByName;
	 
	 /**
	  * 新增日期
	  */
	 public Date addedTime;
	 
	 /**
	  * 新增IP
	  */
	 public String addedIp;    
	
	 /**
	  * 修改人ID
	  */
	 public long lastModifiedBy; 
	 
	 /**
	  * 修改人名字
	  */
	 public String lastModifiedByName;
	 
	 /**
	  * 修改时间
	  */
	 public Date lastModifiedTime;
	 
	 /**
	  * 修改IP
	  */
	 public String lastModifiedIp;
	 
	 /**
	  *  是否有效
	  */
	 public String valid;
	 
	 
	 /**
	 * 起始页
	 */
    private int start;

    /**
	 * 页数
	 */
    private int page    = 1;

    /**
	 * 每页条数
	 */
    private int  rows    = 10;
	 
	 
	 public long getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(long addedBy) {
		this.addedBy = addedBy;
	}

	public String getAddedByName() {
		return addedByName;
	}

	public void setAddedByName(String addedByName) {
		this.addedByName = addedByName;
	}

	public Date getAddedTime() {
		return addedTime;
	}

	public void setAddedTime(Date addedTime) {
		this.addedTime = addedTime;
	}

	public String getAddedIp() {
		return addedIp;
	}

	public void setAddedIp(String addedIp) {
		this.addedIp = addedIp;
	}

	public long getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(long lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getLastModifiedByName() {
		return lastModifiedByName;
	}

	public void setLastModifiedByName(String lastModifiedByName) {
		this.lastModifiedByName = lastModifiedByName;
	}

	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public String getLastModifiedIp() {
		return lastModifiedIp;
	}

	public void setLastModifiedIp(String lastModifiedIp) {
		this.lastModifiedIp = lastModifiedIp;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}
	
	final public int getEnd() {
        return this.start + this.rows;
    }

    public int getStart() {
        start = (this.getPage() - 1) * this.getRows();
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getPage() {
        if (page < 1) {
            page = 1;
        }
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        if (rows < 0) {
            rows = 10;
        }
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
