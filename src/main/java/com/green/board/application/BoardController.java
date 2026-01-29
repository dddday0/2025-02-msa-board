package com.green.board.application;

import com.green.board.application.model.BoardGetOneRes;
import com.green.board.application.model.BoardGetRes;
import com.green.board.application.model.BoardPostReq;
import com.green.board.application.model.BoardPutReq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping ("board")
public class BoardController {
    private final BoardService boardService;

    //BoardService 객체 주소값을 받아서 멤버필드에 대입하는 생성자 생성

    /*public BoardController(BoardService boardService){
        this.boardService = boardService;
        System.out.println(this.boardService);
    }*/

    /* 파라미터(매개변수)는 FE부터 날아오는 데이터를 받는 용도로 사용
        @RequestBody는 JSON 형태로 BODY에 담겨져 있는 데이터를 받을 때 사용.
        JSON 형태와 일치하는 클래스를 만들어 주면 된다. (필드명과 Key값이 같아야 한다)
     */
    @PostMapping
    public int postBoard(@RequestBody BoardPostReq req){
        System.out.println("req: " + req);
        int result = boardService.postBoard(req);
        return result;
    }

    @GetMapping
    public List<BoardGetRes> getBoardList() {
        return boardService.getBoardList();
    }

    @GetMapping("{id}") //문자열 넣으면 통신에러 터짐
    public BoardGetOneRes getBoardOne(@PathVariable int id) {
        System.out.println("id: " + id);
        return boardService.getBoardOne(id);
    }

    @PutMapping
    public int putBoard(@RequestBody BoardPutReq req) {
        System.out.println("req: " + req);
        return boardService.putBoard(req);
    }

    @DeleteMapping
    public int delBoard(@RequestParam int id) {
        System.out.println("delete-id:" + id);
        return boardService.delBoard(id);
    }

}

