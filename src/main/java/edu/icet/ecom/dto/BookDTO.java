package edu.icet.ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookDTO  {
    private String id;
    private String title;
    private String author;
    private String category;
    private String  quantity;
//    private List<BookRentDTO>bookRentDTOList;

}
