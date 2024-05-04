package com.vueSpring.board_project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pagination {
    private  int pageSize;

    int page;
    int block;
    int totalListCnt;
    int totalPageCnt;
    int totalBlockCnt;
    int startPage;
    int endPage;
    int preBlock;
    int nextBlock;
    int startIndex;

    public Pagination(Integer totalListCnt,Integer page,Integer pageSize,Integer blockSize){
        this.page = page;
        this.totalListCnt = totalListCnt;
        totalPageCnt = (int)Math.ceil(totalListCnt*1.0/this.pageSize);
        totalBlockCnt = (int)Math.ceil(totalPageCnt*1.0/blockSize);
        block = (int)Math.ceil((this.page*1.0)/blockSize);
        startPage=((block-1)*(blockSize+1));
        endPage = startPage + blockSize -1;
        if(endPage>totalPageCnt) endPage = totalPageCnt;
        preBlock = (block * blockSize) - blockSize;
        if (preBlock<1)preBlock =1;
        nextBlock = (block * blockSize + 1 );
        if (nextBlock> totalBlockCnt) nextBlock = totalPageCnt;

        startIndex = (this.page -1 )* this.pageSize;
    }
}
