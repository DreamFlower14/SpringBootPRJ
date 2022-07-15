package kopo.poly.service.impl;

import kopo.poly.dto.NoticeDTO;
import kopo.poly.persistance.mapper.INoticeMapper;
import kopo.poly.service.INoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service("NoticeService")
public class NoticeService implements INoticeService {

    private final INoticeMapper noticeMapper;

    @Autowired // resource 랑 같은 역할 Mapper 를 찾아줌
    public NoticeService(INoticeMapper noticeMapper){ this.noticeMapper = noticeMapper;}

    @Override
    public int InsertNoticeInfo(NoticeDTO pDTO) throws Exception{ // service -> info
        log.info(this.getClass().getName() + " .InsertNoticeInfo start!!");
        int res = noticeMapper.InsertNoticeInfo(pDTO);  // 저장되면 1 안되면 0  반환해서 됐는지 안됐는지 알려주는 로직
        log.info(this.getClass().getName() + " .InsertNoticeInfo End!!");
        return res;
    }

    @Override
    public List<NoticeDTO> getNoticeList() throws Exception {
        log.info(this.getClass().getName() + "getNoticeList start ! ");
        List<NoticeDTO> rList = noticeMapper.getNoticeList();
        log.info(this.getClass().getName() + "getNoticeList end!");
        return rList;
    }

    @Override
    public NoticeDTO getNoticeDetail(NoticeDTO pDTO) throws Exception {
        log.info(this.getClass().getName() + "getNoticeDetail Start !");
        NoticeDTO rDTO = noticeMapper.getNoticeDetail(pDTO);
        log.info(this.getClass().getName() + "getNoticeDetail Start !");
        return rDTO;
    }

    @Override
    public int noticeDelete(NoticeDTO nDTO) throws Exception {
        log.info(this.getClass().getName() + "NoticeDelete Start !");
        int res = noticeMapper.noticeDelete(nDTO);
        log.info("res : " + res);
        log.info(this.getClass().getName() + "NoticeDelete Start !");
        return res;
    }

    @Override
    public int noticeUpdate(NoticeDTO nDTO) throws Exception {
        log.info(this.getClass().getName() + " .noticeUpdate Start!!");
        int res = noticeMapper.noticeUpdate(nDTO);
        log.info("res : " + res);
        log.info(this.getClass().getName() + " .noticeUpdate End!!");
        return res;
    }
}