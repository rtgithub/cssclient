/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package njuseaurora.cssclient.businesslogic.procssmngbl.noticebl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import njuseaurora.cssclient.businesslogicservice.processmngblservice.notice.NoticeBLService;
import njuseaurora.cssclient.businesslogicservice.processmngblservice.notice.ROLE;
import njuseaurora.cssclient.dataservice.processmngdataservice.noticedataservice.NoticeDataService;
import njuseaurora.cssclient.po.processmngpo.NoticePO;
import njuseaurora.cssclient.vo.processmngvo.NoticeVO;

/**
 * 
 * @author Administrator
 */
public class NoticeController implements NoticeBLService {
	NoticeDataService noticeDataService;
	NoticeList nList;
	ArrayList<NoticePO> npos;

	public NoticeController() {
		initNoticeList();
		// here will finally use try catch
	}

	private void initNoticeList() {
		try {
			npos = noticeDataService.find();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		nList = new NoticeList(npos);
	}

	public boolean send(NoticeVO nvo, ROLE role) {

		Notice notice = new Notice(nvo);
		return nList.add(nvo) && notice.send(role);

	}

	public boolean send(NoticeVO nvo) {
		Notice notice = new Notice(nvo);
		return nList.add(nvo) && notice.send();
	}

	public NoticeList getNoticeList() {
		return nList;
	}

	public NoticeList getNoticeList(ROLE role) {
    	NoticeList roleList=new NoticeList();
    	Iterator<Notice> iterator=nList.getIterator();
    	while(iterator.hasNext())
    	{
    		if(iterator.next().getRole().equals(role))
    				{
    					roleList.add(iterator.next());
    				}
    	}
        return roleList;
    }

	public NoticeVO getNoice(int inde) {
		return null;
	}
}
