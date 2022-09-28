package devfox.study.board.util;

/**
 * 掲示板ページング処理クラス
 */
public class PageNavigator {
	//ページ関連情報 
	private int countPerPage;		//ページごとに掲示文の数
	private int pagePerGroup;		//グループごとにページの数
	private int currentPage;		//現在のページ
	private int totalRecordsCount;	//全体の掲示文数
	private int totalPageCount;		//全体のページ数
	private int currentGroup;		//現在のグループ
	private int startPageGroup;		//現在のグループの最初のページ
	private int endPageGroup;		//現在のグループの最後のページ
	private int startRecord;		//レコード全体の中で現在のページの最初の文の位置
	
	/*
	 * コンストラクタ
	 */
	public PageNavigator(int countPerPage, int pagePerGroup, int currentPage, int totalRecordsCount) {
		//ページごとに掲示文の数, グループごとにページの数, 現在のページ, 全体の掲示文数
		this.countPerPage = countPerPage;
		this.pagePerGroup = pagePerGroup;
		this.totalRecordsCount = totalRecordsCount;
		
		//全体の掲示文数
		totalPageCount = (totalRecordsCount + countPerPage - 1) / countPerPage;

		//配信されている現在のページが1より小さければ、現在のページを1ページに指定
		if (currentPage < 1)	currentPage = 1;
		//配信されている現在のページが最後のページより大きい場合は、現在のページを最後のページに指定
		if (currentPage > totalPageCount)	currentPage = totalPageCount;
		
		this.currentPage = currentPage;

		//現在のグループ
		currentGroup = (currentPage - 1) / pagePerGroup;
		
		//現在のグループの最初のページ
		startPageGroup = currentGroup * pagePerGroup + 1;
		//現在のグループの最初のページが1より小さければ1に処理
		startPageGroup = startPageGroup < 1 ? 1 : startPageGroup;
		//現在のグループの最後のページ
		endPageGroup = startPageGroup + pagePerGroup - 1;
		//現在のグループの最後のページが全体ページ数より小さければ全体ページ数を最後に
		endPageGroup = endPageGroup < totalPageCount ? endPageGroup : totalPageCount;

		//レコード全体の中で現在のページの最初の文の位置
		startRecord = (currentPage - 1) * countPerPage;			
	}

	/*
	 * Getters and Setters
	 */
	public int getCountPerPage() {
		return countPerPage;
	}

	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}

	public int getPagePerGroup() {
		return pagePerGroup;
	}

	public void setPagePerGroup(int pagePerGroup) {
		this.pagePerGroup = pagePerGroup;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalRecordsCount() {
		return totalRecordsCount;
	}

	public void setTotalRecordsCount(int totalRecordsCount) {
		this.totalRecordsCount = totalRecordsCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getCurrentGroup() {
		return currentGroup;
	}

	public void setCurrentGroup(int currentGroup) {
		this.currentGroup = currentGroup;
	}

	public int getStartPageGroup() {
		return startPageGroup;
	}

	public void setStartPageGroup(int startPageGroup) {
		this.startPageGroup = startPageGroup;
	}

	public int getEndPageGroup() {
		return endPageGroup;
	}

	public void setEndPageGroup(int endPageGroup) {
		this.endPageGroup = endPageGroup;
	}

	public int getStartRecord() {
		return startRecord;
	}

	public void setStartRecord(int startRecord) {
		this.startRecord = startRecord;
	}

	@Override
	public String toString() {
		return "PageNavigator [countPerPage=" + countPerPage + ", pagePerGroup=" + pagePerGroup + ", currentPage="
				+ currentPage + ", totalRecordsCount=" + totalRecordsCount + ", totalPageCount=" + totalPageCount
				+ ", currentGroup=" + currentGroup + ", startPageGroup=" + startPageGroup + ", endPageGroup="
				+ endPageGroup + ", startRecord=" + startRecord + "]";
	}
	
}
