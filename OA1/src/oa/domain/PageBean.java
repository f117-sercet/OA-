package oa.domain;

import java.util.List;

/**
 * ��װҳ����Ϣ
 * @author ��Զϲ������ɯ
 *
 */
public class PageBean {
	/**��ҳ���ύ�����Ĳ���**/
	private int currentPage;//----��ǰҳ��
	private int pageSize;//-------ÿҳ��ʾ����������
	
	/**��ѯ���ݿ���**/
	private int recordCount;//----�ܼ�¼��
	private List recordList;//ҳ��Ҫ��ʾ�����ݼ���
	
	/**������4��������**/
	private int pageCount;//------��ҳ��
	private int beginPageIndex;//-��ʼҳ��
	private int endPageIndex;//---����ҳ��
	
	
	
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public List getRecordList() {
		return recordList;
	}
	public void setRecordList(List recordList) {
		this.recordList = recordList;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getBeginPageIndex() {
		return beginPageIndex;
	}
	public void setBeginPageIndex(int beginPageIndex) {
		this.beginPageIndex = beginPageIndex;
	}
	public int getEndPageIndex() {
		return endPageIndex;
	}
	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}
	public PageBean() {}
	
	public PageBean(int currentPage, int pageSize, int recordCount,List recordList) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.recordCount = recordCount;
		this.recordList = recordList;
		
		pageCount = (this.recordCount + this.pageSize - 1) / this.pageSize;//����ҳ��
		
		if(pageCount <= 10){
			this.beginPageIndex = 1;
			this.endPageIndex = this.pageCount;
		}else{
			this.beginPageIndex = this.currentPage - 4;
			this.endPageIndex = this.currentPage + 5;
			
			if(this.beginPageIndex < 1){
				this.beginPageIndex = 1;
				this.endPageIndex = 10;
			}
			if(this.endPageIndex > this.pageCount){
				this.endPageIndex = this.pageCount;
				this.beginPageIndex = this.endPageIndex - 9;
			}
		}
	}



}


