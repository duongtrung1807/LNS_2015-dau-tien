package com.example.duongtrunghs.luatngansach_2015v2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends Activity {

    HashMap<String,String> lns1=new HashMap<String, String>();
    HashMap<String,String> lns2=new HashMap<String, String>();

    String[] tieude;

    String dieu1="Luật này quy định về lập, chấp hành, kiểm toán, quyết toán, giám sát ngân sách nhà nước; nhiệm vụ, quyền hạn của các cơ quan, tổ chức, đơn vị, cá nhân có liên quan trong lĩnh vực ngân sách nhà nước.";
    String dieu2="<p>\n" +
            "    1. Các cơ quan nhà nước, tổ chức chính trị và các tổ chức chính trị - xã hội.\n" +
            "</p>\n" +
            "<p>\n" +
            "    2. Các tổ chức chính trị xã hội - nghề nghiệp, tổ chức xã hội, tổ chức xã hội - nghề nghiệp được ngân sách nhà nước hỗ trợ theo nhiệm vụ Nhà nước giao.\n" +
            "</p>\n" +
            "<p>\n" +
            "    3. Các đơn vị sự nghiệp công lập.\n" +
            "</p>\n" +
            "<p>\n" +
            "    4. Các tổ chức, cá nhân khác có liên quan đến ngân sách nhà nước.\n" +
            "</p>";
    String dieu3="<p>\n" +
            "    1. Việc lập, chấp hành, kiểm toán, quyết toán, giám sát ngân sách nhà nước phải tuân thủ quy định của Luật này và quy định khác của pháp luật có liên quan.\n" +
            "</p>\n" +
            "<p>\n" +
            "    2. Trường hợp điều ước quốc tế mà Cộng hòa xã hội chủ nghĩa Việt Nam là thành viên có quy định khác với quy định của Luật này thì áp dụng quy định của điều\n" +
            "    ước quốc tế đó.\n" +
            "</p>";

    String dieu4="<p>\n" +
            "    Trong Luật này, các từ ngữ dưới đây được hiểu như sau:\n" +
            "</p>\n" +
            "<p>\n" +
            "    1. <em>Bội chi ngân sách nhà nước</em> bao gồm bội chi ngân sách trung ương và bội chi ngân sách địa phương cấp tỉnh. Bội chi ngân sách trung ương được xác\n" +
            "    định bằng chênh lệch lớn hơn giữa tổng chi ngân sách trung ương không bao gồm chi trả nợ gốc và tổng thu ngân sách trung ương. Bội chi ngân sách địa phương\n" +
            "    cấp tỉnh là tổng hợp bội chi ngân sách cấp tỉnh của từng địa phương, được xác định bằng chênh lệch lớn hơn giữa tổng chi ngân sách cấp tỉnh không bao gồm\n" +
            "    chi trả nợ gốc và tổng thu ngân sách cấp tỉnh của từng địa phương.\n" +
            "</p>\n" +
            "<p>\n" +
            "    2. <em>Cam kết bố trí dự toán chi ngân sách nhà nước</em> là sự chấp thuận theo quy định của pháp luật của cơ quan nhà nước có thẩm quyền về việc bố trí dự\n" +
            "    toán chi năm sau hoặc các năm sau cho chương trình, dự án, nhiệm vụ.\n" +
            "</p>\n" +
            "<p>\n" +
            "    3. <em>Chi dự trữ quốc gia</em> là nhiệm vụ chi của ngân sách nhà nước để mua hàng dự trữ theo quy định của pháp luật về dự trữ quốc gia.\n" +
            "</p>\n" +
            "<p>\n" +
            "    4. <em>Chi đầu tư phát triển</em> là nhiệm vụ chi của ngân sách nhà nước, gồm chi đầu tư xây dựng cơ bản và một số nhiệm vụ chi đầu tư khác theo quy định\n" +
            "    của pháp luật.\n" +
            "</p>\n" +
            "<p>\n" +
            "    5. <em>Chi đầu tư xây dựng cơ bản</em> là nhiệm vụ chi của ngân sách nhà nước để thực hiện các chương trình, dự án đầu tư kết cấu hạ tầng kinh tế - xã hội\n" +
            "    và các chương trình, dự án phục vụ phát triển kinh tế - xã hội.\n" +
            "</p>\n" +
            "<p>\n" +
            "    6. <em>Chi thường xuyên</em> là nhiệm vụ chi của ngân sách nhà nước nhằm bảo đảm hoạt động của bộ máy nhà nước, tổ chức chính trị, tổ chức chính trị - xã\n" +
            "    hội, hỗ trợ hoạt động của các tổ chức khác và thực hiện các nhiệm vụ thường xuyên của Nhà nước về phát triển kinh tế - xã hội, bảo đảm quốc phòng, an ninh.\n" +
            "</p>\n" +
            "<p>\n" +
            "    7. <em>Chi trả nợ</em> là nhiệm vụ chi của ngân sách nhà nước để trả các khoản nợ đến hạn phải trả, bao gồm khoản gốc, lãi, phí và chi phí khác phát sinh\n" +
            "    từ việc vay.\n" +
            "</p>\n" +
            "<p>\n" +
            "    8. <em>Dự phòng ngân sách nhà nước</em> là một khoản mục trong dự toán chi ngân sách chưa phân bổ đã được cơ quan có thẩm quyền quyết định ở từng cấp ngân\n" +
            "    sách.\n" +
            "</p>\n" +
            "<p>\n" +
            "    9. <em>Đơn vị dự toán cấp I</em> là đơn vị dự toán ngân sách được Thủ tướng Chính phủ hoặc Ủy ban nhân dân giao dự toán ngân sách.\n" +
            "</p>\n" +
            "<p>\n" +
            "    10. <em>Đơn vị dự toán ngân sách</em> là cơ quan, tổ chức, đơn vị được cấp có thẩm quyền giao dự toán ngân sách.\n" +
            "</p>\n" +
            "<p>\n" +
            "    11. <em>Đơn vị sử dụng ngân sách</em> là đơn vị dự toán ngân sách được giao trực tiếp quản lý, sử dụng ngân sách.\n" +
            "</p>\n" +
            "<p>\n" +
            "    12. <em>Kết dư ngân sách</em> là chênh lệch lớn hơn giữa tổng số thu ngân sách so với tổng số chi ngân sách của từng cấp ngân sách sau khi kết thúc năm\n" +
            "    ngân sách.\n" +
            "</p>\n" +
            "<p>\n" +
            "    13. <em>Ngân sách địa phương</em> là các khoản thu ngân sách nhà nước phân cấp cho cấp địa phương hưởng, thu bổ sung từ ngân sách trung ương cho ngân sách\n" +
            "    địa phương và các khoản chi ngân sách nhà nước thuộc nhiệm vụ chi của cấp địa phương.\n" +
            "</p>\n" +
            "<p>\n" +
            "    14. <em>Ngân sách nhà nước</em> là toàn bộ các khoản thu, chi của Nhà nước được dự toán và thực hiện trong một khoảng thời gian nhất định do cơ quan nhà\n" +
            "    nước có thẩm quyền quyết định để bảo đảm thực hiện các chức năng, nhiệm vụ của Nhà nước.\n" +
            "</p>\n" +
            "<p>\n" +
            "    15. <em>Ngân sách trung ương</em> là các khoản thu ngân sách nhà nước phân cấp cho cấp trung ương hưởng và các khoản chi ngân sách nhà nước thuộc nhiệm vụ\n" +
            "    chi của cấp trung ương.\n" +
            "</p>\n" +
            "<p>\n" +
            "    16. <em>Phân cấp quản lý ngân sách</em> là việc xác định phạm vi, trách nhiệm và quyền hạn của chính quyền các cấp, các đơn vị dự toán ngân sách trong việc\n" +
            "    quản lý ngân sách nhà nước phù hợp với phân cấp quản lý kinh tế - xã hội.\n" +
            "</p>\n" +
            "<p>\n" +
            "    17. <em>Quỹ dự trữ tài chính</em> là quỹ của Nhà nước, hình thành từ ngân sách nhà nước và các nguồn tài chính khác theo quy định của pháp luật.\n" +
            "</p>\n" +
            "<p>\n" +
            "    18. <em>Quỹ ngân sách nhà nước</em> là toàn bộ các khoản tiền của Nhà nước, kể cả tiền vay có trên tài khoản của ngân sách nhà nước các cấp tại một thời\n" +
            "    điểm.\n" +
            "</p>\n" +
            "<p>\n" +
            "    19. <em>Quỹ tài chính nhà nước ngoài ngân sách</em> là quỹ do cơ quan có thẩm quyền quyết định thành lập, hoạt động độc lập với ngân sách nhà nước, nguồn\n" +
            "    thu, nhiệm vụ chi của quỹ để thực hiện các nhiệm vụ theo quy định của pháp luật.\n" +
            "</p>\n" +
            "<p>\n" +
            "    20. <em>Số bổ sung cân đối ngân sách</em> là khoản ngân sách cấp trên bổ sung cho ngân sách cấp dưới nhằm bảo đảm cho chính quyền cấp dưới cân đối ngân\n" +
            "    sách cấp mình để thực hiện nhiệm vụ được giao.\n" +
            "</p>\n" +
            "<p>\n" +
            "    21. <em>Số bổ sung có mục tiêu</em> là khoản ngân sách cấp trên bổ sung cho ngân sách cấp dưới để hỗ trợ thực hiện các chương trình, dự án, nhiệm vụ cụ\n" +
            "    thể.\n" +
            "</p>\n" +
            "<p>\n" +
            "    22. <em>Số kiểm tra dự toán thu, chi ngân sách</em> là số thu, chi ngân sách nhà nước được cơ quan có thẩm quyền thông báo cho các cấp ngân sách, các cơ\n" +
            "    quan, tổ chức, đơn vị làm căn cứ để xây dựng dự toán ngân sách nhà nước hằng năm và kế hoạch tài chính - ngân sách nhà nước 03 năm.\n" +
            "</p>\n" +
            "<p>\n" +
            "    23. <em>Thời kỳ ổn định ngân sách địa phương</em> là thời kỳ ổn định tỷ lệ phần trăm (%) phân chia các khoản thu giữa các cấp ngân sách và số bổ sung cân\n" +
            "    đối từ ngân sách cấp trên cho ngân sách cấp dưới trong thời gian 05 năm, trùng với kỳ kế hoạch phát triển kinh tế - xã hội 05 năm hoặc theo quyết định của\n" +
            "    Quốc hội.\n" +
            "</p>\n" +
            "<p>\n" +
            "    24. <em>Tỷ lệ phần trăm (%) phân chia các khoản thu giữa các cấp ngân sách</em> là tỷ lệ phần trăm (%) mà từng cấp ngân sách được hưởng trên tổng số các\n" +
            "    khoản thu phân chia giữa các cấp ngân sách.\n" +
            "</p>";

    String dieu5="<p>\n" +
            "    1. Thu ngân sách nhà nước bao gồm:\n" +
            "</p>\n" +
            "<p>\n" +
            "    a) Toàn bộ các khoản thu từ thuế, lệ phí;\n" +
            "</p>\n" +
            "<p>\n" +
            "    b) Toàn bộ các khoản phí thu từ các hoạt động dịch vụ do cơ quan nhà nước thực hiện, trường hợp được khoán chi phí hoạt động thì được khấu trừ; các khoản\n" +
            "    phí thu từ các hoạt động dịch vụ do đơn vị sự nghiệp công lập và doanh nghiệp nhà nước thực hiện nộp ngân sách nhà nước theo quy định của pháp luật;\n" +
            "</p>\n" +
            "<p>\n" +
            "    c) Các khoản viện trợ không hoàn lại của Chính phủ các nước, các tổ chức, cá nhân ở ngoài nước cho Chính phủ Việt Nam và chính quyền địa phương;\n" +
            "</p>\n" +
            "<p>\n" +
            "    d) Các khoản thu khác theo quy định của pháp luật.\n" +
            "</p>\n" +
            "<p>\n" +
            "    2. Chi ngân sách nhà nước bao gồm:\n" +
            "</p>\n" +
            "<p>\n" +
            "    a) Chi đầu tư phát triển;\n" +
            "</p>\n" +
            "<p>\n" +
            "    b) Chi dự trữ quốc gia;\n" +
            "</p>\n" +
            "<p>\n" +
            "    c) Chi thường xuyên;\n" +
            "</p>\n" +
            "<p>\n" +
            "    d) Chi trả nợ lãi;\n" +
            "</p>\n" +
            "<p>\n" +
            "    đ) Chi viện trợ;\n" +
            "</p>\n" +
            "<p>\n" +
            "    e) Các khoản chi khác theo quy định của pháp luật.\n" +
            "</p>\n" +
            "<p>\n" +
            "    3. Bội chi ngân sách nhà nước.\n" +
            "</p>\n" +
            "<p>\n" +
            "    4. Tổng mức vay của ngân sách nhà nước, bao gồm vay bù đắp bội chi và vay để trả nợ gốc của ngân sách nhà nước.\n" +
            "</p>";
    String dieu6="<p>\n" +
            "    1. Ngân sách nhà nước gồm ngân sách trung ương và ngân sách địa phương.\n" +
            "</p>\n" +
            "<p>\n" +
            "    2. Ngân sách địa phương gồm ngân sách của các cấp chính quyền địa phương.\n" +
            "</p>";
    String dieu7="<p>\n" +
            "    1. Các khoản thu từ thuế, phí, lệ phí và các khoản thu khác theo quy định của pháp luật được tổng hợp đầy đủ vào cân đối ngân sách nhà nước, theo nguyên\n" +
            "    tắc không gắn với nhiệm vụ chi cụ thể. Trường hợp có khoản thu cần gắn với nhiệm vụ chi cụ thể theo quy định của pháp luật thì được bố trí tương ứng từ các\n" +
            "    khoản thu này trong dự toán chi ngân sách để thực hiện. Việc ban hành chính sách thu ngân sách phải bảo đảm nguyên tắc cân đối ngân sách trong trung hạn,\n" +
            "    dài hạn và thực hiện các cam kết về hội nhập quốc tế.\n" +
            "</p>\n" +
            "<p>\n" +
            "    2. Ngân sách nhà nước được cân đối theo nguyên tắc tổng số thu từ thuế, phí, lệ phí phải lớn hơn tổng số chi thường xuyên và góp phần tích lũy ngày càng\n" +
            "    cao để chi đầu tư phát triển; trường hợp còn bội chi thì số bội chi phải nhỏ hơn số chi đầu tư phát triển, tiến tới cân bằng thu, chi ngân sách; trường hợp\n" +
            "    đặc biệt Chính phủ trình Quốc hội xem xét, quyết định. Trường hợp bội thu ngân sách thì được sử dụng để trả nợ gốc và lãi các khoản vay của ngân sách nhà\n" +
            "    nước.\n" +
            "</p>\n" +
            "<p>\n" +
            "    3. Vay bù đắp bội chi ngân sách nhà nước chỉ được sử dụng cho đầu tư phát triển, không sử dụng cho chi thường xuyên.\n" +
            "</p>\n" +
            "<p>\n" +
            "    4. Bội chi ngân sách trung ương được bù đắp từ các nguồn sau:\n" +
            "</p>\n" +
            "<p>\n" +
            "    a) Vay trong nước từ phát hành trái phiếu chính phủ, công trái xây dựng Tổ quốc và các khoản vay trong nước khác theo quy định của pháp luật;\n" +
            "</p>\n" +
            "<p>\n" +
            "    b) Vay ngoài nước từ các khoản vay của Chính phủ các nước, các tổ chức quốc tế và phát hành trái phiếu chính phủ ra thị trường quốc tế, không bao gồm các\n" +
            "    khoản vay về cho vay lại.\n" +
            "</p>\n" +
            "<p>\n" +
            "    5. Bội chi ngân sách địa phương:\n" +
            "</p>\n" +
            "<p>\n" +
            "    a) Chi ngân sách địa phương cấp tỉnh được bội chi; bội chi ngân sách địa phương chỉ được sử dụng để đầu tư các dự án thuộc kế hoạch đầu tư công trung hạn\n" +
            "    đã được Hội đồng nhân dân cấp tỉnh quyết định;\n" +
            "</p>\n" +
            "<p>\n" +
            "    b) Bội chi ngân sách địa phương được bù đắp bằng các nguồn vay trong nước từ phát hành trái phiếu chính quyền địa phương, vay lại từ nguồn Chính phủ vay về\n" +
            "    cho vay lại và các khoản vay trong nước khác theo quy định của pháp luật;\n" +
            "</p>\n" +
            "<p>\n" +
            "    c) Bội chi ngân sách địa phương được tổng hợp vào bội chi ngân sách nhà nước và do Quốc hội quyết định. Chính phủ quy định cụ thể điều kiện được phép bội\n" +
            "    chi ngân sách địa phương để bảo đảm phù hợp với khả năng trả nợ của địa phương và tổng mức bội chi chung của ngân sách nhà nước.\n" +
            "</p>\n" +
            "<p>\n" +
            "    6. Mức dư nợ vay của ngân sách địa phương:\n" +
            "</p>\n" +
            "<p>\n" +
            "    a) Đối với thành phố Hà Nội và thành phố Hồ Chí Minh không vượt quá 60% số thu ngân sách địa phương được hưởng theo phân cấp;\n" +
            "</p>\n" +
            "<p>\n" +
            "    b) Đối với các địa phương có số thu ngân sách địa phương được hưởng theo phân cấp lớn hơn chi thường xuyên của ngân sách địa phương không vượt quá 30% số\n" +
            "    thu ngân sách được hưởng theo phân cấp;\n" +
            "</p>\n" +
            "<p>\n" +
            "    c) Đối với các địa phương có số thu ngân sách địa phương được hưởng theo phân cấp nhỏ hơn hoặc bằng chi thường xuyên của ngân sách địa phương không vượt\n" +
            "    quá 20% số thu ngân sách được hưởng theo phân cấp.\n" +
            "</p>";
    String dieu8="<p>\n" +
            "    1. Ngân sách nhà nước được quản lý thống nhất, tập trung dân chủ, hiệu quả, tiết kiệm, công khai, minh bạch, công bằng; có phân công, phân cấp quản lý; gắn\n" +
            "    quyền hạn với trách nhiệm của cơ quan quản lý nhà nước các cấp.\n" +
            "</p>\n" +
            "<p>\n" +
            "    2. Toàn bộ các khoản thu, chi ngân sách phải được dự toán, tổng hợp đầy đủ vào ngân sách nhà nước.\n" +
            "</p>\n" +
            "<p>\n" +
            "    3. Các khoản thu ngân sách thực hiện theo quy định của các luật thuế và chế độ thu theo quy định của pháp luật.\n" +
            "</p>\n" +
            "<p>\n" +
            "    4. Các khoản chi ngân sách chỉ được thực hiện khi có dự toán được cấp có thẩm quyền giao và phải bảo đảm đúng chế độ, tiêu chuẩn, định mức chi do cơ quan\n" +
            "    nhà nước có thẩm quyền quy định. Ngân sách các cấp, đơn vị dự toán ngân sách, đơn vị sử dụng ngân sách không được thực hiện nhiệm vụ chi khi chưa có nguồn\n" +
            "    tài chính, dự toán chi ngân sách làm phát sinh nợ khối lượng xây dựng cơ bản, nợ kinh phí thực hiện nhiệm vụ chi thường xuyên.\n" +
            "</p>\n" +
            "<p>\n" +
            "    5. Bảo đảm ưu tiên bố trí ngân sách để thực hiện các chủ trương, chính sách của Đảng, Nhà nước trong từng thời kỳ về phát triển kinh tế; xóa đói, giảm\n" +
            "    nghèo; chính sách dân tộc; thực hiện mục tiêu bình đẳng giới; phát triển nông nghiệp, nông thôn, giáo dục, đào tạo, y tế, khoa học và công nghệ và những\n" +
            "    chính sách quan trọng khác.\n" +
            "</p>\n" +
            "<p>\n" +
            "    6. Bố trí ngân sách để thực hiện nhiệm vụ phát triển kinh tế - xã hội; bảo đảm quốc phòng, an ninh, đối ngoại, kinh phí hoạt động của bộ máy nhà nước.\n" +
            "</p>\n" +
            "<p>\n" +
            "    7. Ngân sách nhà nước bảo đảm cân đối kinh phí hoạt động của tổ chức chính trị và các tổ chức chính trị - xã hội.\n" +
            "</p>\n" +
            "<p>\n" +
            "    8. Kinh phí hoạt động của các tổ chức chính trị xã hội - nghề nghiệp, tổ chức xã hội, tổ chức xã hội - nghề nghiệp được thực hiện theo nguyên tắc tự bảo\n" +
            "    đảm; ngân sách nhà nước chỉ hỗ trợ cho các nhiệm vụ Nhà nước giao theo quy định của Chính phủ.\n" +
            "</p>\n" +
            "<p>\n" +
            "    9. Bảo đảm chi trả các khoản nợ lãi đến hạn thuộc nhiệm vụ chi của ngân sách nhà nước.\n" +
            "</p>\n" +
            "<p>\n" +
            "    10. Việc quyết định đầu tư và chi đầu tư chương trình, dự án có sử dụng vốn ngân sách nhà nước phải phù hợp với Luật đầu tư công và quy định của pháp luật\n" +
            "    có liên quan.\n" +
            "</p>\n" +
            "<p>\n" +
            "    11. Ngân sách nhà nước không hỗ trợ kinh phí hoạt động cho các quỹ tài chính nhà nước ngoài ngân sách. Trường hợp được ngân sách nhà nước hỗ trợ vốn điều\n" +
            "    lệ theo quy định của pháp luật thì phải phù hợp với khả năng của ngân sách nhà nước và chỉ thực hiện khi đáp ứng đủ các điều kiện sau: được thành lập và\n" +
            "    hoạt động theo đúng quy định của pháp luật; có khả năng tài chính độc lập; có nguồn thu, nhiệm vụ chi không trùng với nguồn thu, nhiệm vụ chi của ngân sách\n" +
            "    nhà nước.\n" +
            "</p>";
    String dieu9="<p>\n" +
            "    1. Ngân sách trung ương, ngân sách mỗi cấp chính quyền địa phương được phân cấp nguồn thu và nhiệm vụ chi cụ thể.\n" +
            "</p>\n" +
            "<p>\n" +
            "    2. Ngân sách trung ương giữ vai trò chủ đạo, bảo đảm thực hiện các nhiệm vụ chi quốc gia, hỗ trợ địa phương chưa cân đối được ngân sách và hỗ trợ các địa\n" +
            "    phương theo quy định tại khoản 3 Điều 40 của Luật này.\n" +
            "</p>\n" +
            "<p>\n" +
            "    3. Ngân sách địa phương được phân cấp nguồn thu bảo đảm chủ động thực hiện những nhiệm vụ chi được giao. Hội đồng nhân dân cấp tỉnh quyết định việc phân\n" +
            "    cấp nguồn thu, nhiệm vụ chi giữa các cấp ngân sách ở địa phương phù hợp với phân cấp quản lý kinh tế - xã hội, quốc phòng, an ninh và trình độ quản lý của\n" +
            "    mỗi cấp trên địa bàn.\n" +
            "</p>\n" +
            "<p>\n" +
            "    4. Nhiệm vụ chi thuộc ngân sách cấp nào do ngân sách cấp đó bảo đảm; việc ban hành và thực hiện chính sách, chế độ mới làm tăng chi ngân sách phải có giải\n" +
            "    pháp bảo đảm nguồn tài chính, phù hợp với khả năng cân đối của ngân sách từng cấp; việc quyết định đầu tư các chương trình, dự án sử dụng vốn ngân sách\n" +
            "    phải bảo đảm trong phạm vi ngân sách theo phân cấp.\n" +
            "</p>\n" +
            "<p>\n" +
            "    5. Trường hợp cơ quan quản lý nhà nước thuộc ngân sách cấp trên ủy quyền cho cơ quan quản lý nhà nước thuộc ngân sách cấp dưới thực hiện nhiệm vụ chi của\n" +
            "    mình thì phải phân bổ và giao dự toán cho cơ quan cấp dưới được ủy quyền để thực hiện nhiệm vụ chi đó. Cơ quan nhận kinh phí ủy quyền phải quyết toán với\n" +
            "    cơ quan ủy quyền khoản kinh phí này.\n" +
            "</p>\n" +
            "<p>\n" +
            "    6. Thực hiện phân chia theo tỷ lệ phần trăm (%) đối với các khoản thu phân chia giữa các cấp ngân sách và số bổ sung từ ngân sách cấp trên cho ngân sách\n" +
            "    cấp dưới trên cơ sở bảo đảm công bằng, phát triển cân đối giữa các vùng, các địa phương.\n" +
            "</p>\n" +
            "<p>\n" +
            "    7. Trong thời kỳ ổn định ngân sách:\n" +
            "</p>\n" +
            "<p>\n" +
            "    a) Không thay đổi tỷ lệ phần trăm (%) phân chia các khoản thu giữa các cấp ngân sách;\n" +
            "</p>\n" +
            "<p>\n" +
            "    b) Hằng năm, căn cứ khả năng cân đối của ngân sách cấp trên, cơ quan có thẩm quyền quyết định tăng thêm số bổ sung cân đối ngân sách từ ngân sách cấp trên\n" +
            "    cho ngân sách cấp dưới so với năm đầu thời kỳ ổn định;\n" +
            "</p>\n" +
            "<p>\n" +
            "    c) Số bổ sung có mục tiêu từ ngân sách cấp trên cho ngân sách cấp dưới được xác định theo nguyên tắc, tiêu chí và định mức phân bổ ngân sách và các chế độ,\n" +
            "    tiêu chuẩn, định mức chi ngân sách; khả năng của ngân sách cấp trên và khả năng cân đối ngân sách của từng địa phương cấp dưới;\n" +
            "</p>\n" +
            "<p>\n" +
            "    d) Các địa phương được sử dụng nguồn tăng thu hằng năm mà ngân sách địa phương được hưởng theo phân cấp để tăng chi thực hiện các nhiệm vụ phát triển kinh\n" +
            "    tế - xã hội, bảo đảm quốc phòng, an ninh. Đối với số tăng thu so với dự toán thực hiện theo quy định tại khoản 2 Điều 59 của Luật này.\n" +
            "</p>\n" +
            "<p>\n" +
            "    Trường hợp đặc biệt có phát sinh nguồn thu từ dự án mới đi vào hoạt động trong thời kỳ ổn định ngân sách làm ngân sách địa phương tăng thu lớn thì số tăng\n" +
            "    thu phải nộp về ngân sách cấp trên. Chính phủ trình Quốc hội, Ủy ban nhân dân cấp tỉnh trình Hội đồng nhân dân cùng cấp quyết định thu về ngân sách cấp\n" +
            "    trên số tăng thu này và thực hiện bổ sung có mục tiêu một phần cho ngân sách cấp dưới theo quy định tại điểm d khoản 3 Điều 40 của Luật này để hỗ trợ đầu\n" +
            "    tư cơ sở hạ tầng ở địa phương theo dự án được cấp có thẩm quyền phê duyệt;\n" +
            "</p>\n" +
            "<p>\n" +
            "    đ) Trường hợp ngân sách địa phương hụt thu so với dự toán do nguyên nhân khách quan thực hiện theo quy định tại khoản 3 Điều 59 của Luật này.\n" +
            "</p>\n" +
            "<p>\n" +
            "    8. Sau mỗi thời kỳ ổn định ngân sách, các địa phương phải tăng khả năng tự cân đối, phát triển ngân sách địa phương, thực hiện giảm dần tỷ lệ bổ sung cân\n" +
            "    đối từ ngân sách cấp trên so với tổng chi ngân sách địa phương hoặc tăng tỷ lệ phần trăm (%) nộp về ngân sách cấp trên đối với các khoản thu phân chia giữa\n" +
            "    các cấp ngân sách để tăng nguồn lực cho ngân sách cấp trên thực hiện các nhiệm vụ chi quốc gia và phát triển đồng đều giữa các địa phương.\n" +
            "</p>\n" +
            "<p>\n" +
            "    9. Không được dùng ngân sách của cấp này để chi cho nhiệm vụ của cấp khác và không được dùng ngân sách của địa phương này để chi cho nhiệm vụ của địa\n" +
            "    phương khác, trừ các trường hợp sau:\n" +
            "</p>\n" +
            "<p>\n" +
            "    a) Ngân sách cấp dưới hỗ trợ cho các đơn vị thuộc cấp trên quản lý đóng trên địa bàn trong trường hợp cần khẩn trương huy động lực lượng cấp trên khi xảy\n" +
            "    ra thiên tai, thảm họa, dịch bệnh và các trường hợp cấp thiết khác để bảo đảm ổn định tình hình kinh tế - xã hội, an ninh và trật tự, an toàn xã hội của\n" +
            "    địa phương;\n" +
            "</p>\n" +
            "<p>\n" +
            "    b) Các đơn vị cấp trên quản lý đóng trên địa bàn khi thực hiện chức năng của mình, kết hợp thực hiện một số nhiệm vụ theo yêu cầu của cấp dưới;\n" +
            "</p>\n" +
            "<p>\n" +
            "    c) Sử dụng dự phòng ngân sách địa phương để hỗ trợ các địa phương khác khắc phục hậu quả thiên tai, thảm họa nghiêm trọng.\n" +
            "</p>\n" +
            "<p>\n" +
            "    10. Trường hợp thực hiện điều ước quốc tế dẫn đến giảm nguồn thu của ngân sách trung ương, Chính phủ trình Quốc hội điều chỉnh việc phân chia nguồn thu\n" +
            "    giữa ngân sách trung ương và ngân sách địa phương để bảo đảm vai trò chủ đạo của ngân sách trung ương.\n" +
            "</p>";
    String dieu10="<p>\n" +
            "    1. Mức bố trí dự phòng từ 2% đến 4% tổng chi ngân sách mỗi cấp.\n" +
            "</p>\n" +
            "<p>\n" +
            "    2. Dự phòng ngân sách nhà nước sử dụng để:\n" +
            "</p>\n" +
            "<p>\n" +
            "    a) Chi phòng, chống, khắc phục hậu quả thiên tai, thảm họa, dịch bệnh, cứu đói; nhiệm vụ quan trọng về quốc phòng, an ninh và các nhiệm vụ cần thiết khác\n" +
            "    thuộc nhiệm vụ chi của ngân sách cấp mình mà chưa được dự toán;\n" +
            "</p>\n" +
            "<p>\n" +
            "    b) Chi hỗ trợ cho ngân sách cấp dưới để thực hiện nhiệm vụ quy định tại điểm a khoản này, sau khi ngân sách cấp dưới đã sử dụng dự phòng cấp mình để thực\n" +
            "    hiện nhưng chưa đáp ứng được nhu cầu;\n" +
            "</p>\n" +
            "<p>\n" +
            "    c) Chi hỗ trợ các địa phương khác theo quy định tại điểm c khoản 9 Điều 9 của Luật này.\n" +
            "</p>\n" +
            "<p>\n" +
            "    3. Thẩm quyền quyết định sử dụng dự phòng ngân sách nhà nước:\n" +
            "</p>\n" +
            "<p>\n" +
            "    a) Chính phủ quy định thẩm quyền quyết định sử dụng dự phòng ngân sách trung ương, định kỳ báo cáo Ủy ban thường vụ Quốc hội việc sử dụng dự phòng ngân\n" +
            "    sách trung ương và báo cáo Quốc hội tại kỳ họp gần nhất;\n" +
            "</p>\n" +
            "<p>\n" +
            "    b) Ủy ban nhân dân các cấp quyết định sử dụng dự phòng ngân sách cấp mình, định kỳ báo cáo Thường trực Hội đồng nhân dân và báo cáo Hội đồng nhân dân cùng\n" +
            "    cấp tại kỳ họp gần nhất.\n" +
            "</p>";

    String dieu11="<p>1. Chính phủ, Ủy ban nhân dân tỉnh, thành phố trực thuộc trung ương (sau đây gọi chung là cấp tỉnh) lập quỹ dự trữ tài chính từ các nguồn tăng thu, kết dư ngân sách, bố trí trong dự toán chi ngân sách hằng năm và các nguồn tài chính khác theo quy định của pháp luật, số dư của quỹ dự trữ tài chính ở mỗi cấp không vượt quá 25% dự toán chi ngân sách hằng năm của cấp đó.</p>\n" +
            "\n" +
            "<p>2. Quỹ dự trữ tài chính được sử dụng trong các trường hợp sau:</p>\n" +
            "\n" +
            "<p>a) Cho ngân sách tạm ứng để đáp ứng các nhu cầu chi theo dự toán chi ngân sách khi nguồn thu chưa tập trung kịp và phải hoàn trả ngay trong năm ngân sách;</p>\n" +
            "\n" +
            "<p>b) Trường hợp thu ngân sách nhà nước hoặc vay để bù đắp bội chi không đạt mức dự toán được Quốc hội, Hội đồng nhân dân quyết định và thực hiện các nhiệm vụ phòng, chống, khắc phục hậu quả thiên tai, thảm họa, dịch bệnh trên diện rộng, với mức độ nghiêm trọng, nhiệm vụ về quốc phòng, an ninh và nhiệm vụ cấp bách khác phát sinh ngoài dự toán mà sau khi sắp xếp lại ngân sách, sử dụng hết dự phòng ngân sách mà vẫn chưa đủ nguồn, được sử dụng quỹ dự trữ tài chính để đáp ứng các nhu cầu chi nhưng mức sử dụng trong năm tối đa không quá 70% số dư đầu năm của quỹ.</p>\n" +
            "\n" +
            "<p>3. Chính phủ quy định thẩm quyền quyết định sử dụng quỹ dự trữ tài chính.</p>\n";
    String dieu12="<p>1. Thu ngân sách nhà nước phải được thực hiện theo quy định của Luật này, các luật về thuế và các quy định khác của pháp luật về thu ngân sách nhà nước.</p>\n" +
            "\n" +
            "<p>2. Chi ngân sách nhà nước chỉ được thực hiện khi đã có trong dự toán ngân sách được giao, trừ trường hợp quy định tại Điều 51 của Luật này; đã được thủ trưởng đơn vị sử dụng ngân sách, chủ đầu tư hoặc người được ủy quyền quyết định chi và đáp ứng các điều kiện trong từng trường hợp sau đây:</p>\n" +
            "\n" +
            "<p>a) Đối với chi đầu tư xây dựng cơ bản phải đáp ứng các điều kiện theo quy định của pháp luật về đầu tư công và xây dựng;</p>\n" +
            "\n" +
            "<p>b) Đối với chi thường xuyên phải bảo đảm đúng chế độ, tiêu chuẩn, định mức chi ngân sách do cơ quan nhà nước có thẩm quyền quy định; trường hợp các cơ quan, đơn vị đã được cấp có thẩm quyền cho phép thực hiện theo cơ chế tự chủ, tự chịu trách nhiệm về sử dụng biên chế và kinh phí thì thực hiện theo quy chế chi tiêu nội bộ và phù hợp với dự toán được giao tự chủ;</p>\n" +
            "\n" +
            "<p>c) Đối với chi dự trữ quốc gia phải bảo đảm các điều kiện theo quy định của pháp luật về dự trữ quốc gia;</p>\n" +
            "\n" +
            "<p>d) Đối với những gói thầu thuộc các nhiệm vụ, chương trình, dự án cần phải đấu thầu để lựa chọn nhà thầu cung cấp dịch vụ tư vấn, mua sắm hàng hóa, xây lắp phải tổ chức đấu thầu theo quy định của pháp luật về đấu thầu;</p>\n" +
            "\n" +
            "<p>đ) Đối với những khoản chi cho công việc thực hiện theo phương thức Nhà nước đặt hàng, giao kế hoạch phải theo quy định về giá hoặc phí và lệ phí do cơ quan có thẩm quyền ban hành.</p>\n";
    String dieu13="<p>1. Thu, chi ngân sách nhà nước được hạch toán bằng Đồng Việt Nam. Trường hợp các khoản thu, chi ngân sách nhà nước bằng ngoại tệ thì được quy đổi ra Đồng Việt Nam theo tỷ giá hạch toán do cơ quan có thẩm quyền quy định để hạch toán thu, chi ngân sách nhà nước tại thời điểm phát sinh.</p>\n" +
            "\n" +
            "<p>2. Các khoản thu, chi của ngân sách nhà nước phải được hạch toán kế toán, quyết toán đầy đủ, kịp thời, đúng chế độ.</p>\n" +
            "\n" +
            "<p>3. Kế toán và quyết toán ngân sách nhà nước được thực hiện thống nhất theo chế độ kế toán nhà nước, mục lục ngân sách nhà nước và quy định của Luật này.</p>\n" +
            "\n" +
            "<p>4. Chứng từ thu, chi ngân sách nhà nước được phát hành, sử dụng và quản lý theo quy định của pháp luật.</p>\n";
    String dieu14="<p>Năm ngân sách bắt đầu từ ngày 01 tháng 01 và kết thúc vào ngày 31 tháng 12 năm dương lịch.</p>\n";
    String dieu15="<p>1. Dự toán ngân sách nhà nước trình Quốc hội, Hội đồng nhân dân; dự toán ngân sách nhà nước đã được cấp có thẩm quyền quyết định; báo cáo tình hình thực hiện ngân sách nhà nước; quyết toán ngân sách nhà nước được Quốc hội, Hội đồng nhân dân phê chuẩn; dự toán, tình hình thực hiện, quyết toán ngân sách của các đơn vị dự toán ngân sách, các tổ chức được ngân sách nhà nước hỗ trợ và các chương trình, dự án đầu tư xây dựng cơ bản sử dụng vốn ngân sách nhà nước được công khai theo quy định sau đây:</p>\n" +
            "\n" +
            "<p>a) Nội dung công khai bao gồm: số liệu và báo cáo thuyết minh dự toán ngân sách nhà nước trình Quốc hội, Hội đồng nhân dân, dự toán đã được cấp có thẩm quyền quyết định, tình hình thực hiện ngân sách nhà nước và quyết toán ngân sách nhà nước; kết quả thực hiện các kiến nghị của Kiểm toán nhà nước; trừ số liệu chi tiết, báo cáo thuyết minh thuộc lĩnh vực quốc phòng, an ninh, dự trữ quốc gia;</p>\n" +
            "\n" +
            "<p>b) Việc công khai ngân sách nhà nước được thực hiện bằng một hoặc một số hình thức: công bố tại kỳ họp, niêm yết tại trụ sở làm việc của cơ quan, tổ chức, đơn vị; phát hành ấn phẩm; thông báo bằng văn bản đến các cơ quan, tổ chức, đơn vị, cá nhân có liên quan; đưa lên trang thông tin điện tử; thông báo trên các phương tiện thông tin đại chúng;</p>\n" +
            "\n" +
            "<p>c) Báo cáo dự toán ngân sách nhà nước phải được công khai chậm nhất là 05 ngày làm việc kể từ ngày Chính phủ gửi đại biểu Quốc hội, Ủy ban nhân dân gửi đại biểu Hội đồng nhân dân.</p>\n" +
            "\n" +
            "<p>Báo cáo dự toán ngân sách nhà nước đã được cấp có thẩm quyền quyết định, báo cáo quyết toán ngân sách nhà nước đã được cấp có thẩm quyền phê chuẩn, kết quả kiểm toán ngân sách nhà nước, kết quả thực hiện các kiến nghị của Kiểm toán nhà nước phải được công khai chậm nhất là 30 ngày kể từ ngày văn bản được ban hành.</p>\n" +
            "\n" +
            "<p>Báo cáo tình hình thực hiện ngân sách nhà nước hằng quý, 06 tháng phải được công khai chậm nhất là 15 ngày kể từ ngày kết thúc quý và 06 tháng.</p>\n" +
            "\n" +
            "<p>Báo cáo tình hình thực hiện ngân sách nhà nước hằng năm được công khai khi Chính phủ trình Quốc hội vào kỳ họp giữa năm sau.</p>\n" +
            "\n" +
            "<p>2. Công khai thủ tục ngân sách nhà nước:</p>\n" +
            "\n" +
            "<p>a) Đối tượng phải thực hiện công khai gồm các cơ quan thu, cơ quan tài chính và Kho bạc Nhà nước;</p>\n" +
            "\n" +
            "<p>b) Nội dung công khai bao gồm: các quy định về quy trình, thủ tục kê khai, thu, nộp, miễn giảm, gia hạn, hoàn lại các khoản thu; tạm ứng, cấp phát, thanh toán ngân sách nhà nước;</p>\n" +
            "\n" +
            "<p>c) Việc công khai được thực hiện bằng các hình thức niêm yết tại nơi giao dịch và công bố trên trang thông tin điện tử của cơ quan.</p>\n" +
            "\n" +
            "<p>3. Nội dung công khai phải bảo đảm đầy đủ theo các chỉ tiêu, biểu mẫu do Bộ Tài chính quy định.</p>\n" +
            "\n" +
            "<p>4. Các đối tượng có trách nhiệm phải thực hiện công khai theo quy định tại khoản 1 và khoản 2 Điều này, nếu không thực hiện công khai đầy đủ, đúng hạn thì sẽ bị xử lý theo quy định của pháp luật.</p>\n" +
            "\n" +
            "<p>5. Chính phủ quy định chi tiết về công khai ngân sách nhà nước.</p>\n";
    String dieu16="<p>1. Ngân sách nhà nước được giám sát bởi cộng đồng. Mặt trận Tổ quốc Việt Nam các cấp chủ trì tổ chức việc giám sát ngân sách nhà nước của cộng đồng. Nội dung giám sát ngân sách nhà nước của cộng đồng gồm:</p>\n" +
            "\n" +
            "<p>a) Việc chấp hành các quy định của pháp luật về quản lý, sử dụng ngân sách nhà nước;</p>\n" +
            "\n" +
            "<p>b) Tình hình thực hiện dự toán ngân sách nhà nước hằng năm;</p>\n" +
            "\n" +
            "<p>c) Việc thực hiện công khai ngân sách nhà nước theo quy định tại Điều 15 của Luật này.</p>\n" +
            "\n" +
            "<p>2. Chính phủ quy định chi tiết về giám sát ngân sách nhà nước của cộng đồng.</p>\n";
    String dieu17="<p>1. Kế hoạch tài chính 05 năm là kế hoạch tài chính được lập trong thời hạn 05 năm cùng với kế hoạch phát triển kinh tế - xã hội 05 năm. Kế hoạch tài chính 05 năm xác định mục tiêu tổng quát, mục tiêu cụ thể về tài chính - ngân sách nhà nước; các định hướng lớn về tài chính, ngân sách nhà nước; số thu và cơ cấu thu nội địa, thu dầu thô, thu cân đối từ hoạt động xuất khẩu, nhập khẩu; số chi và cơ cấu chi đầu tư phát triển, chi trả nợ, chi thường xuyên; định hướng về bội chi ngân sách; giới hạn nợ nước ngoài của quốc gia, nợ công, nợ chính phủ; các giải pháp chủ yếu để thực hiện kế hoạch.</p>\n" +
            "\n" +
            "<p>2. Kế hoạch tài chính 05 năm được sử dụng để:</p>\n" +
            "\n" +
            "<p>a) Thực hiện các mục tiêu phát triển kinh tế - xã hội của quốc gia, ngành, lĩnh vực và địa phương; cân đối, sử dụng có hiệu quả nguồn lực tài chính công và ngân sách nhà nước trong trung hạn; thúc đẩy việc công khai, minh bạch ngân sách nhà nước;</p>\n" +
            "\n" +
            "<p>b) Làm cơ sở để cấp có thẩm quyền xem xét, quyết định kế hoạch đầu tư trung hạn nguồn ngân sách nhà nước;</p>\n" +
            "\n" +
            "<p>c) Định hướng cho công tác lập dự toán ngân sách nhà nước hằng năm, kế hoạch tài chính - ngân sách nhà nước 03 năm.</p>\n" +
            "\n" +
            "<p>3. Kế hoạch tài chính 05 năm gồm kế hoạch tài chính 05 năm quốc gia và kế hoạch tài chính 05 năm tỉnh, thành phố trực thuộc trung ương.</p>\n" +
            "\n" +
            "<p>4. Bộ Tài chính có trách nhiệm chủ trì xây dựng kế hoạch tài chính 05 năm quốc gia trình Chính phủ báo cáo Quốc hội; Sở Tài chính có trách nhiệm xây dựng kế hoạch tài chính 05 năm của địa phương mình trình Ủy ban nhân dân cùng cấp báo cáo Hội đồng nhân dân xem xét, quyết định cùng với thời điểm trình dự toán ngân sách năm đầu kỳ kế hoạch.</p>\n" +
            "\n" +
            "<p>5. Chính phủ quy định chi tiết việc lập kế hoạch tài chính 05 năm.</p>\n";
    String dieu18="<p>1. Lợi dụng chức vụ, quyền hạn để chiếm đoạt hoặc thiếu trách nhiệm làm thiệt hại đến nguồn thu ngân sách nhà nước.</p>\n" +
            "\n" +
            "<p>2. Thu sai quy định của các luật thuế và quy định khác của pháp luật về thu ngân sách; phân chia sai quy định nguồn thu giữa ngân sách các cấp; giữ lại nguồn thu của ngân sách nhà nước sai chế độ; tự đặt ra các khoản thu trái với quy định của pháp luật.</p>\n" +
            "\n" +
            "<p>3. Chi không có dự toán, trừ trường hợp quy định tại Điều 51 của Luật này; chi không đúng dự toán ngân sách được giao; chi sai chế độ, tiêu chuẩn, định mức chi, không đúng mục đích; tự đặt ra các khoản chi trái với quy định của pháp luật.</p>\n" +
            "\n" +
            "<p>4. Quyết định đầu tư chương trình, dự án có sử dụng vốn ngân sách không đúng thẩm quyền, không xác định rõ nguồn vốn để thực hiện.</p>\n" +
            "\n" +
            "<p>5. Thực hiện vay trái với quy định của pháp luật; vay vượt quá khả năng cân đối của ngân sách.</p>\n" +
            "\n" +
            "<p>6. Sử dụng ngân sách nhà nước để cho vay, tạm ứng, góp vốn trái với quy định của pháp luật.</p>\n" +
            "\n" +
            "<p>7. Trì hoãn việc chi ngân sách khi đã bảo đảm các điều kiện chi theo quy định của pháp luật.</p>\n" +
            "\n" +
            "<p>8. Hạch toán sai chế độ kế toán nhà nước và mục lục ngân sách nhà nước.</p>\n" +
            "\n" +
            "<p>9. Lập, trình dự toán, quyết toán ngân sách nhà nước chậm so với thời hạn quy định.</p>\n" +
            "\n" +
            "<p>10. Phê chuẩn, duyệt quyết toán ngân sách nhà nước sai quy định của pháp luật</p>\n" +
            "\n" +
            "<p>11. Xuất quỹ ngân sách nhà nước tại Kho bạc Nhà nước mà khoản chi đó không có trong dự toán đã được cơ quan có thẩm quyền quyết định, trừ trường hợp tạm cấp ngân sách và ứng trước dự toán ngân sách năm sau quy định tại Điều 51 và Điều 57 của Luật này.</p>\n" +
            "\n" +
            "<p>12. Các hành vi bị cấm khác trong lĩnh vực ngân sách nhà nước theo quy định của các luật có liên quan.</p>\n";
    String dieu19="";
    String dieu20="<p>1. Làm luật và sửa đổi luật trong lĩnh vực tài chính - ngân sách.</p>\n" +
            "\n" +
            "<p>2. Quyết định chính sách cơ bản về tài chính - ngân sách nhà nước; quy định, sửa đổi hoặc bãi bỏ các thứ thuế; quyết định mức giới hạn an toàn nợ quốc gia, nợ công, nợ chính phủ.</p>\n" +
            "\n" +
            "<p>3. Quyết định kế hoạch tài chính 05 năm.</p>\n" +
            "\n" +
            "<p>4. Quyết định dự toán ngân sách nhà nước:</p>\n" +
            "\n" +
            "<p>a) Tổng số thu ngân sách nhà nước, bao gồm thu nội địa, thu dầu thô, thu từ hoạt động xuất khẩu và nhập khẩu, thu viện trợ không hoàn lại;</p>\n" +
            "\n" +
            "<p>b) Tổng số chi ngân sách nhà nước, bao gồm chi ngân sách trung ương và chi ngân sách địa phương, chi tiết theo chi đầu tư phát triển, chi dự trữ quốc gia, chi thường xuyên, chi trả nợ lãi, chi viện trợ, chi bổ sung quỹ dự trữ tài chính, dự phòng ngân sách. Trong chi đầu tư phát triển và chi thường xuyên có mức chi cụ thể cho các lĩnh vực giáo dục - đào tạo và dạy nghề; khoa học và công nghệ;</p>\n" +
            "\n" +
            "<p>c) Bội chi ngân sách nhà nước bao gồm bội chi ngân sách trung ương và bội chi ngân sách địa phương, chi tiết từng địa phương; nguồn bù đắp bội chi ngân sách nhà nước;</p>\n" +
            "\n" +
            "<p>đ) Tổng mức vay của ngân sách nhà nước, bao gồm vay để bù đắp bội chi ngân sách nhà nước và vay để trả nợ gốc của ngân sách nhà nước.</p>\n" +
            "\n" +
            "<p>5. Quyết định phân bổ ngân sách trung ương:</p>\n" +
            "\n" +
            "<p>a) Tổng số chi ngân sách trung ương được phân bổ; chi đầu tư phát triển theo từng lĩnh vực; chi thường xuyên theo từng lĩnh vực; chi dự trữ quốc gia; chi trả nợ lãi, chi viện trợ; chi bổ sung quỹ dự trữ tài chính; dự phòng ngân sách;</p>\n" +
            "\n" +
            "<p>b) Dự toán chi đầu tư phát triển, chi thường xuyên, chi dự trữ quốc gia, chi viện trợ của từng bộ, cơ quan ngang bộ, cơ quan thuộc Chính phủ và cơ quan khác ở trung ương theo từng lĩnh vực;</p>\n" +
            "\n" +
            "<p>c) Mức bổ sung từ ngân sách trung ương cho ngân sách từng địa phương, bao gồm bổ sung cân đối ngân sách và bổ sung có mục tiêu.</p>\n" +
            "\n" +
            "<p>6. Quyết định tỷ lệ phần trăm (%) phân chia giữa ngân sách trung ương và ngân sách từng địa phương đối với các khoản thu quy định tại khoản 2 Điều 35 của Luật này.</p>\n" +
            "\n" +
            "<p>7. Quyết định chủ trương đầu tư các chương trình mục tiêu quốc gia, dự án quan trọng quốc gia được đầu tư từ nguồn ngân sách nhà nước.</p>\n" +
            "\n" +
            "<p>8. Quyết định điều chỉnh dự toán ngân sách nhà nước trong trường hợp cần thiết.</p>\n" +
            "\n" +
            "<p>9. Phê chuẩn quyết toán ngân sách nhà nước.</p>\n" +
            "\n" +
            "<p>10. Giám sát việc thực hiện ngân sách nhà nước, chính sách cơ bản về tài chính - ngân sách quốc gia, nghị quyết của Quốc hội về ngân sách nhà nước.</p>\n" +
            "\n" +
            "<p>11. Bãi bỏ văn bản của Chủ tịch nước, Ủy ban thường vụ Quốc hội, Chính phủ, Thủ tướng Chính phủ, Tòa án nhân dân tối cao, Viện kiểm sát nhân dân tối cao về lĩnh vực tài chính - ngân sách trái với Hiến pháp, luật và nghị quyết của Quốc hội.</p>\n";
    String dieu21="<p>1. Ban hành pháp lệnh, nghị quyết về lĩnh vực tài chính - ngân sách theo quy định của pháp luật.</p>\n" +
            "\n" +
            "<p>2. Cho ý kiến về các dự án luật, các báo cáo và các dự án khác về lĩnh vực tài chính - ngân sách do Chính phủ trình Quốc hội.</p>\n" +
            "\n" +
            "<p>3. Ban hành Quy chế lập, thẩm tra, quyết định dự toán ngân sách nhà nước, phương án phân bổ ngân sách trung ương và phê chuẩn quyết toán ngân sách nhà nước.</p>\n" +
            "\n" +
            "<p>4. Cho ý kiến về các chế độ chi ngân sách quan trọng, phạm vi ảnh hưởng rộng, liên quan đến việc thực hiện nhiệm vụ kinh tế - xã hội của đất nước do Chính phủ trình.</p>\n" +
            "\n" +
            "<p>5. Quyết định về:</p>\n" +
            "\n" +
            "<p>a) Nguyên tắc, tiêu chí và định mức phân bổ ngân sách nhà nước;</p>\n" +
            "\n" +
            "<p>b) Bổ sung dự toán số tăng thu ngân sách nhà nước; phân bổ, sử dụng số tăng thu, số tiết kiệm chi của ngân sách trung ương, báo cáo Quốc hội tại kỳ họp gần nhất.</p>\n" +
            "\n" +
            "<p>6. Giám sát việc thực hiện luật, nghị quyết của Quốc hội; pháp lệnh, nghị quyết của Ủy ban thường vụ Quốc hội về lĩnh vực tài chính - ngân sách.</p>\n" +
            "\n" +
            "<p>7. Đình chỉ việc thi hành các văn bản quy phạm pháp luật của Chính phủ, Thủ tướng Chính phủ về lĩnh vực tài chính - ngân sách trái với Hiến pháp, luật, nghị quyết của Quốc hội, trình Quốc hội tại kỳ họp gần nhất quyết định việc hủy bỏ các văn bản đó.</p>\n" +
            "\n" +
            "<p>8. Bãi bỏ các văn bản quy phạm pháp luật của Chính phủ, Thủ tướng Chính phủ về lĩnh vực tài chính - ngân sách trái với pháp lệnh, nghị quyết của Ủy ban thường vụ Quốc hội.</p>\n" +
            "\n" +
            "<p>9. Bãi bỏ các nghị quyết của Hội đồng nhân dân cấp tỉnh về lĩnh vực tài chính - ngân sách trái với Hiến pháp, luật, nghị quyết của Quốc hội, pháp lệnh và nghị quyết của Ủy ban thường vụ Quốc hội.</p>\n";
    String dieu22="<p>1. Thẩm tra dự án luật, dự án pháp lệnh và các báo cáo, dự án khác về lĩnh vực tài chính - ngân sách do Quốc hội, Ủy ban thường vụ Quốc hội giao.</p>\n" +
            "\n" +
            "<p>2. Chủ trì thẩm tra dự toán ngân sách nhà nước, phương án phân bổ ngân sách trung ương, phương án điều chỉnh dự toán ngân sách nhà nước, báo cáo về thực hiện ngân sách nhà nước và quyết toán ngân sách nhà nước, nguyên tắc, tiêu chí và định mức phân bổ ngân sách và phương án sử dụng số tăng thu, số tiết kiệm chi của ngân sách trung ương do Chính phủ trình Quốc hội, Ủy ban thường vụ Quốc hội.</p>\n" +
            "\n" +
            "<p>3. Thẩm tra các chế độ chi ngân sách quan trọng, phạm vi ảnh hưởng rộng, liên quan đến việc thực hiện nhiệm vụ kinh tế - xã hội của đất nước do Chính phủ trình Ủy ban thường vụ Quốc hội.</p>\n" +
            "\n" +
            "<p>4. Giám sát việc thực hiện luật, nghị quyết của Quốc hội, pháp lệnh, nghị quyết của Ủy ban thường vụ Quốc hội về lĩnh vực tài chính - ngân sách; giám sát việc thực hiện ngân sách nhà nước và chính sách tài chính - ngân sách.</p>\n" +
            "\n" +
            "<p>5. Giám sát văn bản quy phạm pháp luật của Chính phủ, Thủ tướng Chính phủ, Bộ trưởng, Thủ trưởng cơ quan ngang bộ, văn bản quy phạm pháp luật liên tịch giữa các cơ quan có thẩm quyền ở trung ương về lĩnh vực tài chính - ngân sách.</p>\n" +
            "\n" +
            "<p>6. Kiến nghị các vấn đề trong lĩnh vực tài chính - ngân sách.</p>\n";
    String dieu23="<p>1. Trong phạm vi nhiệm vụ, quyền hạn của mình, phối hợp với Ủy ban tài chính, ngân sách của Quốc hội, các cơ quan có liên quan của Chính phủ để thẩm tra các dự án luật, pháp lệnh, dự toán ngân sách nhà nước, phương án phân bổ ngân sách trung ương, báo cáo về tình hình thực hiện ngân sách nhà nước, quyết toán ngân sách nhà nước và các dự án, báo cáo khác về lĩnh vực tài chính - ngân sách được phân công phụ trách do Chính phủ trình Quốc hội, Ủy ban thường vụ Quốc hội.</p>\n" +
            "\n" +
            "<p>2. Giám sát việc thực hiện luật, nghị quyết của Quốc hội, pháp lệnh, nghị quyết của Ủy ban thường vụ Quốc hội về tài chính - ngân sách; giám sát việc thực hiện ngân sách nhà nước và chính sách tài chính - ngân sách trong lĩnh vực phụ trách.</p>\n" +
            "\n" +
            "<p>3. Kiến nghị các vấn đề về tài chính - ngân sách trong lĩnh vực phụ trách.</p>\n";
    String dieu24="<p>1. Thực hiện kiểm toán ngân sách nhà nước và báo cáo kết quả kiểm toán với Quốc hội, Ủy ban thường vụ Quốc hội; gửi báo cáo kiểm toán cho Chủ tịch nước, Chính phủ, Thủ tướng Chính phủ, Hội đồng dân tộc, Ủy ban của Quốc hội và các cơ quan khác có liên quan theo quy định của Luật Kiểm toán nhà nước.</p>\n" +
            "\n" +
            "<p>2. Trình Quốc hội báo cáo kiểm toán quyết toán ngân sách nhà nước để Quốc hội xem xét, phê chuẩn quyết toán ngân sách nhà nước.</p>\n" +
            "\n" +
            "<p>3. Tham gia với Ủy ban tài chính, ngân sách và các cơ quan khác của Quốc hội, Chính phủ trong việc xem xét, thẩm tra báo cáo về dự toán ngân sách nhà nước, phương án phân bổ ngân sách trung ương, phương án điều chỉnh dự toán ngân sách nhà nước.</p>\n";
    String dieu25="<p>1. Công bố luật, pháp lệnh về lĩnh vực tài chính - ngân sách.</p>\n" +
            "\n" +
            "<p>2. Thực hiện nhiệm vụ, quyền hạn do Hiến pháp và pháp luật quy định trong việc tiến hành đàm phán, ký kết, quyết định phê chuẩn hoặc trình Quốc hội phê chuẩn điều ước quốc tế về lĩnh vực tài chính - ngân sách.</p>\n" +
            "\n" +
            "<p>3. Yêu cầu Chính phủ họp bàn về hoạt động tài chính - ngân sách nhà nước khi cần thiết.</p>";
    String dieu26="<p>1. Trình Quốc hội, Ủy ban thường vụ Quốc hội các dự án luật, pháp lệnh và các báo cáo, dự án khác về lĩnh vực tài chính - ngân sách; ban hành các văn bản quy phạm pháp luật về lĩnh vực tài chính - ngân sách theo thẩm quyền.</p>\n" +
            "\n" +
            "<p>2. Lập và trình Quốc hội kế hoạch tài chính 05 năm, kế hoạch tài chính - ngân sách nhà nước 03 năm.</p>\n" +
            "\n" +
            "<p>3. Lập và trình Quốc hội dự toán ngân sách nhà nước và phương án phân bổ ngân sách trung ương hằng năm; dự toán điều chỉnh ngân sách nhà nước trong trường hợp cần thiết.</p>\n" +
            "\n" +
            "<p>4. Căn cứ vào nghị quyết của Quốc hội về dự toán ngân sách nhà nước và phân bổ ngân sách trung ương quyết định giao nhiệm vụ thu, chi ngân sách cho từng bộ, cơ quan ngang bộ, cơ quan thuộc Chính phủ và cơ quan khác ở trung ương theo nội dung quy định tại điểm b khoản 5 Điều 19 của Luật này; nhiệm vụ thu, chi, bội chi, tỷ lệ phần trăm (%) phân chia giữa ngân sách trung ương và ngân sách từng địa phương đối với các khoản thu phân chia và mức bổ sung từ ngân sách trung ương cho từng tỉnh, thành phố trực thuộc trung ương theo nội dung quy định tại các điểm a, b, c và d khoản 4, điểm c khoản 5 và khoản 6 Điều 19 của Luật này.</p>\n" +
            "\n" +
            "<p>5. Thống nhất quản lý ngân sách nhà nước, bảo đảm sự phối hợp chặt chẽ giữa cơ quan quản lý ngành và địa phương trong việc thực hiện ngân sách nhà nước.</p>\n" +
            "\n" +
            "<p>6. Quyết định các giải pháp và tổ chức điều hành thực hiện ngân sách nhà nước được Quốc hội quyết định; kiểm tra việc thực hiện ngân sách nhà nước; báo cáo Quốc hội, Ủy ban thường vụ Quốc hội về tình hình thực hiện ngân sách nhà nước, các chương trình mục tiêu quốc gia, dự án quan trọng quốc gia do Quốc hội quyết định chủ trương đầu tư.</p>\n" +
            "\n" +
            "<p>7. Báo cáo Quốc hội, Ủy ban thường vụ Quốc hội về tài chính - ngân sách khi có yêu cầu.</p>\n" +
            "\n" +
            "<p>8. Quy định quy trình, thủ tục lập dự toán, thu nộp, kiểm soát, thanh toán chi ngân sách, quyết toán ngân sách; ứng trước dự toán ngân sách năm sau; sử dụng dự phòng ngân sách; sử dụng quỹ dự trữ tài chính và các quỹ tài chính khác của Nhà nước theo quy định của Luật này và quy định khác của pháp luật có liên quan.</p>\n" +
            "\n" +
            "<p>9. Quyết định những chế độ chi ngân sách quan trọng, phạm vi ảnh hưởng rộng, liên quan đến việc thực hiện nhiệm vụ kinh tế - xã hội của cả nước sau khi xin ý kiến Ủy ban thường vụ Quốc hội.</p>\n" +
            "\n" +
            "<p>10. Quyết định các chế độ, tiêu chuẩn, định mức chi tiêu thực hiện thống nhất trong cả nước; đối với một số chế độ, tiêu chuẩn, định mức chi ngân sách, để phù hợp đặc điểm của địa phương, quy định khung và giao Hội đồng nhân dân cấp tỉnh quyết định cụ thể.</p>\n" +
            "\n" +
            "<p>11. Xây dựng các nguyên tắc, tiêu chí và định mức phân bổ ngân sách trình Ủy ban thường vụ Quốc hội quyết định làm căn cứ xây dựng dự toán, phân bổ ngân sách cho các bộ, cơ quan ngang bộ, cơ quan thuộc Chính phủ, các cơ quan khác ở trung ương và các địa phương.</p>\n" +
            "\n" +
            "<p>12. Hướng dẫn, kiểm tra Hội đồng nhân dân trong việc thực hiện văn bản của cơ quan nhà nước cấp trên; kiểm tra tính hợp pháp các nghị quyết của Hội đồng nhân dân.</p>\n" +
            "\n" +
            "<p>13. Lập và trình Quốc hội quyết toán ngân sách nhà nước, quyết toán các chương trình, dự án quan trọng quốc gia do Quốc hội quyết định chủ trương đầu tư.</p>\n" +
            "\n" +
            "<p>14. Ban hành Quy chế xem xét, quyết định dự toán và phân bổ ngân sách địa phương, phê chuẩn quyết toán ngân sách địa phương.</p>\n" +
            "\n" +
            "<p>15. Quy định việc thực hiện quản lý ngân sách theo kết quả thực hiện nhiệm vụ.</p>";
    String dieu27="<p>1. Chuẩn bị các dự án luật, pháp lệnh, kế hoạch tài chính 05 năm, kế hoạch tài chính - ngân sách nhà nước 03 năm, các dự án khác về lĩnh vực tài chính - ngân sách, trình Chính phủ; ban hành các văn bản quy phạm pháp luật về lĩnh vực tài chính - ngân sách theo thẩm quyền.</p>\n" +
            "\n" +
            "<p>2. Xây dựng nguyên tắc, tiêu chí và định mức phân bổ chi thường xuyên của ngân sách nhà nước; các chế độ, tiêu chuẩn, định mức chi ngân sách, cơ chế quản lý tài chính - ngân sách nhà nước, chế độ kế toán, thanh toán, quyết toán, mục lục ngân sách nhà nước, chế độ báo cáo, công khai tài chính - ngân sách trình Chính phủ quy định hoặc quy định theo phân cấp của Chính phủ để thi hành thống nhất trong cả nước.</p>\n" +
            "\n" +
            "<p>3. Quyết định ban hành chế độ, tiêu chuẩn, định mức chi ngân sách đối với các ngành, lĩnh vực sau khi thống nhất với các bộ quản lý ngành, lĩnh vực; trường hợp không thống nhất, Bộ Tài chính trình Thủ tướng Chính phủ xem xét, cho ý kiến trước khi quyết định.</p>\n" +
            "\n" +
            "<p>4. Lập, trình Chính phủ dự toán ngân sách nhà nước, phương án phân bổ ngân sách trung ương, dự toán điều chỉnh ngân sách nhà nước trong trường hợp cần thiết. Tổ chức thực hiện ngân sách nhà nước; thống nhất quản lý và chỉ đạo công tác thu thuế, phí, lệ phí, các khoản vay và thu khác của ngân sách, các nguồn viện trợ quốc tế; tổ chức thực hiện chi ngân sách nhà nước theo đúng dự toán được giao. Tổng hợp, lập quyết toán ngân sách nhà nước trình Chính phủ.</p>\n" +
            "\n" +
            "<p>5. Chủ trì xây dựng trình cấp có thẩm quyền phê duyệt mục tiêu, định hướng huy động, sử dụng vốn vay và quản lý nợ công trong từng giai đoạn 05 năm; chương trình quản lý nợ trung hạn; hệ thống các chỉ tiêu giám sát nợ chính phủ, nợ công, nợ nước ngoài của quốc gia; kế hoạch vay, trả nợ hằng năm của Chính phủ.</p>\n" +
            "\n" +
            "<p>6. Kiểm tra các quy định về tài chính - ngân sách của các bộ, cơ quan ngang bộ, Hội đồng nhân dân, Ủy ban nhân dân và Chủ tịch Ủy ban nhân dân cấp tỉnh; trường hợp quy định trong các văn bản đó trái với Hiến pháp, luật, nghị quyết của Quốc hội, pháp lệnh, nghị quyết của Ủy ban thường vụ Quốc hội và các văn bản của các cơ quan nhà nước cấp trên thì có quyền:</p>\n" +
            "\n" +
            "<p>a) Kiến nghị Bộ trưởng, Thủ trưởng cơ quan ngang bộ đình chỉ việc thi hành hoặc bãi bỏ đối với những văn bản của bộ, cơ quan ngang bộ;</p>\n" +
            "\n" +
            "<p>b) Kiến nghị Thủ tướng Chính phủ đình chỉ việc thi hành nghị quyết của Hội đồng nhân dân cấp tỉnh;</p>\n" +
            "\n" +
            "<p>c) Kiến nghị Thủ tướng Chính phủ bãi bỏ đối với những quy định của Ủy ban nhân dân và Chủ tịch Ủy ban nhân dân cấp tỉnh theo quy định của pháp luật.</p>\n" +
            "\n" +
            "<p>7. Thanh tra, kiểm tra tài chính - ngân sách, xử lý hoặc kiến nghị cấp có thẩm quyền xử lý theo quy định của pháp luật đối với các vi phạm về chế độ quản lý tài chính - ngân sách của các bộ, cơ quan ngang bộ, cơ quan thuộc Chính phủ, cơ quan khác ở trung ương, các địa phương, các tổ chức kinh tế, đơn vị hành chính, đơn vị sự nghiệp công lập và các đối tượng khác có nghĩa vụ nộp ngân sách nhà nước và sử dụng ngân sách nhà nước.</p>\n" +
            "\n" +
            "<p>8. Quản lý quỹ ngân sách nhà nước, quỹ dự trữ nhà nước và các quỹ khác của Nhà nước theo quy định của pháp luật.</p>\n" +
            "\n" +
            "<p>9. Đánh giá hiệu quả chi ngân sách nhà nước.</p>\n" +
            "\n" +
            "<p>10. Thực hiện công khai ngân sách nhà nước theo quy định tại Điều 15 của Luật này.</p>";
    String dieu28="<p>1. Xây dựng nguyên tắc, tiêu chí và định mức phân bổ vốn đầu tư phát triển của ngân sách nhà nước trình Chính phủ; lập phương án phân bổ chi đầu tư phát triển của ngân sách trung ương.</p>\n" +
            "\n" +
            "<p>2. Phối hợp với Bộ Tài chính và các bộ, cơ quan có liên quan xây dựng kế hoạch tài chính 05 năm, dự toán ngân sách nhà nước hằng năm và kế hoạch tài chính - ngân sách nhà nước 03 năm.</p>";
    String dieu29="<p>1. Phối hợp với Bộ Tài chính xây dựng và triển khai thực hiện phương án vay để bù đắp bội chi ngân sách nhà nước.</p>\n" +
            "\n" +
            "<p>2. Tạm ứng cho ngân sách nhà nước để xử lý thiếu hụt tạm thời quỹ ngân sách nhà nước theo quyết định của Thủ tướng Chính phủ.</p>";
    String dieu30="<p>1. Lập dự toán ngân sách hằng năm, kế hoạch tài chính - ngân sách nhà nước 03 năm của cơ quan mình.</p>\n" +
            "\n" +
            "<p>2. Phối hợp với Bộ Tài chính và các bộ, cơ quan có liên quan trong quá trình tổng hợp dự toán ngân sách nhà nước, phương án phân bổ ngân sách trung ương hằng năm, kế hoạch tài chính 05 năm, kế hoạch tài chính - ngân sách nhà nước 03 năm, quyết toán ngân sách hằng năm thuộc ngành, lĩnh vực phụ trách.</p>\n" +
            "\n" +
            "<p>3. Kiểm tra, theo dõi tình hình thực hiện ngân sách thuộc ngành, lĩnh vực phụ trách.</p>\n" +
            "\n" +
            "<p>4. Báo cáo tình hình thực hiện kết quả, hiệu quả sử dụng ngân sách thuộc ngành, lĩnh vực phụ trách.</p>\n" +
            "\n" +
            "<p>5. Ban hành các định mức kỹ thuật - kinh tế làm cơ sở cho việc quản lý ngân sách theo kết quả thực hiện nhiệm vụ thuộc ngành, lĩnh vực phụ trách.</p>\n" +
            "\n" +
            "<p>6. Phối hợp với Bộ Tài chính trong việc xây dựng chế độ, tiêu chuẩn, định mức chi ngân sách thuộc ngành, lĩnh vực phụ trách.</p>\n" +
            "\n" +
            "<p>7. Quản lý, tổ chức thực hiện và quyết toán, công khai đối với ngân sách được giao; bảo đảm sử dụng hiệu quả ngân sách nhà nước.</p>\n" +
            "\n" +
            "<p>8. Bộ trưởng, Thủ trưởng cơ quan ngang bộ, cơ quan thuộc Chính phủ, cơ quan khác ở trung ương tổ chức thực hiện đúng nhiệm vụ, quyền hạn được giao trong lĩnh vực tài chính - ngân sách và chịu trách nhiệm về những sai phạm thuộc phạm vi quản lý theo quy định của pháp luật.</p>";
    String dieu31="<p>1. Căn cứ vào nhiệm vụ thu, chi ngân sách được cấp trên giao và tình hình thực tế tại địa phương, quyết định:</p>\n" +
            "\n" +
            "<p>a) Dự toán thu ngân sách nhà nước trên địa bàn, bao gồm thu nội địa, thu dầu thô, thu từ hoạt động xuất khẩu, nhập khẩu, thu viện trợ không hoàn lại, bảo đảm không thấp hơn dự toán thu ngân sách nhà nước được cấp trên giao;</p>\n" +
            "\n" +
            "<p>b) Dự toán thu ngân sách địa phương, bao gồm các khoản thu ngân sách địa phương hưởng 100%, phần ngân sách địa phương được hưởng từ các khoản thu phân chia theo tỷ lệ phần trăm (%), thu bổ sung từ ngân sách cấp trên;</p>\n" +
            "\n" +
            "<p>c) Dự toán chi ngân sách địa phương, bao gồm chi ngân sách cấp mình và chi ngân sách địa phương cấp dưới, chi tiết theo chi đầu tư phát triển, chi thường xuyên, chi trả nợ lãi, chi bổ sung quỹ dự trữ tài chính, dự phòng ngân sách. Trong chi đầu tư phát triển và chi thường xuyên có mức chi cụ thể cho các lĩnh vực giáo dục - đào tạo và dạy nghề, khoa học và công nghệ;</p>\n" +
            "\n" +
            "<p>d) Tổng mức vay của ngân sách địa phương, bao gồm vay để bù đắp bội chi ngân sách địa phương và vay để trả nợ gốc của ngân sách địa phương.</p>\n" +
            "\n" +
            "<p>2. Quyết định phân bổ dự toán ngân sách cấp mình:</p>\n" +
            "\n" +
            "<p>a) Tổng số; chi đầu tư phát triển và chi thường xuyên theo từng lĩnh vực; chi bổ sung quỹ dự trữ tài chính địa phương; dự phòng ngân sách;</p>\n" +
            "\n" +
            "<p>b) Dự toán chi đầu tư phát triển, chi thường xuyên của từng cơ quan, đơn vị thuộc cấp mình theo từng lĩnh vực;</p>\n" +
            "\n" +
            "<p>c) Mức bổ sung cho ngân sách từng địa phương cấp dưới trực tiếp, gồm bổ sung cân đối ngân sách, bổ sung có mục tiêu.</p>\n" +
            "\n" +
            "<p>3. Phê chuẩn quyết toán ngân sách địa phương.</p>\n" +
            "\n" +
            "<p>4. Quyết định các chủ trương, biện pháp để triển khai thực hiện ngân sách địa phương.</p>\n" +
            "\n" +
            "<p>5. Quyết định điều chỉnh dự toán ngân sách địa phương trong trường hợp cần thiết.</p>\n" +
            "\n" +
            "<p>6. Giám sát việc thực hiện ngân sách đã được Hội đồng nhân dân quyết định.</p>\n" +
            "\n" +
            "<p>7. Bãi bỏ văn bản quy phạm pháp luật về tài chính - ngân sách của Ủy ban nhân dân, Chủ tịch Ủy ban nhân dân cùng cấp và Hội đồng nhân dân cấp dưới trực tiếp trái với Hiến pháp, luật, nghị quyết của Quốc hội, pháp lệnh, nghị quyết của Ủy ban thường vụ Quốc hội và các văn bản của cơ quan nhà nước cấp trên.</p>\n" +
            "\n" +
            "<p>8. Quyết định danh mục các chương trình, dự án thuộc kế hoạch đầu tư trung hạn nguồn ngân sách nhà nước của ngân sách cấp mình; quyết định chương trình, dự án đầu tư quan trọng của địa phương được đầu tư từ nguồn vốn ngân sách nhà nước.</p>\n" +
            "\n" +
            "<p>9. Đối với Hội đồng nhân dân cấp tỉnh, ngoài nhiệm vụ, quyền hạn quy định tại các khoản 1, 2, 3, 4, 5, 6, 7 và 8 Điều này còn có nhiệm vụ, quyền hạn:</p>\n" +
            "\n" +
            "<p>a) Quyết định kế hoạch tài chính 05 năm gồm các nội dung: mục tiêu tổng quát, mục tiêu cụ thể của kế hoạch tài chính 05 năm; khả năng thu ngân sách nhà nước trên địa bàn; thu, chi ngân sách địa phương, bội chi ngân sách địa phương và giới hạn mức vay của ngân sách địa phương; giải pháp chủ yếu để thực hiện kế hoạch;</p>\n" +
            "\n" +
            "<p>b) Bội chi ngân sách địa phương và nguồn bù đắp bội chi ngân sách địa phương hằng năm;</p>\n" +
            "\n" +
            "<p>c) Quyết định việc phân cấp nguồn thu, nhiệm vụ chi cho từng cấp ngân sách ở địa phương theo quy định tại khoản 3 Điều 9 của Luật này;</p>\n" +
            "\n" +
            "<p>d) Quyết định tỷ lệ phần trăm (%) phân chia giữa ngân sách các cấp chính quyền địa phương đối với phần ngân sách địa phương được hưởng từ các khoản thu quy định tại khoản 2 Điều 37 của Luật này và các khoản thu phân chia giữa các cấp ngân sách ở địa phương;</p>\n" +
            "\n" +
            "<p>đ) Quyết định thu phí, lệ phí và các khoản đóng góp của nhân dân theo quy định của pháp luật;</p>\n" +
            "\n" +
            "<p>e) Quyết định nguyên tắc, tiêu chí và định mức phân bổ ngân sách ở địa phương;</p>\n" +
            "\n" +
            "<p>g) Quyết định cụ thể đối với một số chế độ, tiêu chuẩn, định mức chi ngân sách theo quy định khung của Chính phủ;</p>\n" +
            "\n" +
            "<p>h) Quyết định các chế độ chi ngân sách đối với một số nhiệm vụ chi có tính chất đặc thù ở địa phương ngoài các chế độ, tiêu chuẩn, định mức chi ngân sách do Chính phủ, Bộ trưởng Bộ Tài chính ban hành để thực hiện nhiệm vụ phát triển kinh tế - xã hội, bảo đảm trật tự, an toàn xã hội trên địa bàn, phù hợp với khả năng cân đối của ngân sách địa phương.</p>\n" +
            "\n" +
            "<p>Chính phủ quy định chi tiết điểm này.</p>";
    String dieu32="<p>1. Lập dự toán ngân sách địa phương, phương án phân bổ ngân sách cấp mình theo các nội dung quy định tại khoản 1 và khoản 2 Điều 30 của Luật này; dự toán điều chỉnh ngân sách địa phương trong trường hợp cần thiết, trình Hội đồng nhân dân cùng cấp quyết định và báo cáo cơ quan hành chính nhà nước, cơ quan tài chính cấp trên trực tiếp.</p>\n" +
            "\n" +
            "<p>2. Lập quyết toán ngân sách địa phương trình Hội đồng nhân dân cùng cấp phê chuẩn và báo cáo cơ quan hành chính nhà nước, cơ quan tài chính cấp trên trực tiếp.</p>\n" +
            "\n" +
            "<p>3. Kiểm tra nghị quyết của Hội đồng nhân dân cấp dưới về lĩnh vực tài chính - ngân sách.</p>\n" +
            "\n" +
            "<p>4. Căn cứ vào nghị quyết của Hội đồng nhân dân cùng cấp, quyết định giao nhiệm vụ thu, chi ngân sách cho từng cơ quan, đơn vị trực thuộc; nhiệm vụ thu, chi, mức bổ sung cho ngân sách cấp dưới và tỷ lệ phần trăm (%) phân chia giữa các cấp ngân sách ở địa phương đối với các khoản thu phân chia.</p>\n" +
            "\n" +
            "<p>5. Quyết định các giải pháp và tổ chức thực hiện dự toán ngân sách địa phương được Hội đồng nhân dân quyết định; kiểm tra, báo cáo việc thực hiện ngân sách địa phương.</p>\n" +
            "\n" +
            "<p>6. Phối hợp với các cơ quan nhà nước cấp trên trong việc quản lý ngân sách nhà nước trên địa bàn.</p>\n" +
            "\n" +
            "<p>7. Báo cáo, công khai ngân sách nhà nước theo quy định của pháp luật.</p>\n" +
            "\n" +
            "<p>8. Thực hiện quản lý ngân sách theo kết quả thực hiện nhiệm vụ theo quy định của Chính phủ.</p>\n" +
            "\n" +
            "<p>9. Đối với Ủy ban nhân dân cấp tỉnh, ngoài các nhiệm vụ, quyền hạn quy định tại các khoản 1, 2, 3, 4, 5, 6, 7 và 8 Điều này còn có nhiệm vụ:</p>\n" +
            "\n" +
            "<p>a) Lập và trình Hội đồng nhân dân cùng cấp quyết định các nội dung quy định tại khoản 9 Điều 30 của Luật này;</p>\n" +
            "\n" +
            "<p>b) Lập kế hoạch tài chính - ngân sách nhà nước 03 năm theo quy định tại Điều 43 của Luật này;</p>\n" +
            "\n" +
            "<p>c) Quyết định sử dụng quỹ dự trữ tài chính và các quỹ tài chính khác của Nhà nước theo quy định của Luật này và quy định khác của pháp luật có liên quan.</p>\n" +
            "\n" +
            "<p>10. Chỉ đạo cơ quan tài chính địa phương chủ trì phối hợp với các cơ quan liên quan giúp Ủy ban nhân dân thực hiện nhiệm vụ theo quy định tại các khoản 1, 2, 3, 4, 5, 6, 7, 8 và 9 Điều này.</p>\n" +
            "\n" +
            "<p>11. Chủ tịch Ủy ban nhân dân các cấp tổ chức thực hiện đúng nhiệm vụ, quyền hạn được giao trong lĩnh vực tài chính - ngân sách và chịu trách nhiệm về những sai phạm thuộc phạm vi quản lý theo quy định của pháp luật.</p>";
    String dieu33="<p>1. Lập dự toán thu, chi ngân sách hằng năm; thực hiện phân bổ dự toán ngân sách được cấp có thẩm quyền giao cho các đơn vị trực thuộc và điều chỉnh phân bổ dự toán theo thẩm quyền; lập kế hoạch tài chính - ngân sách nhà nước 03 năm thuộc phạm vi quản lý theo quy định tại Điều 43 của Luật này.</p>\n" +
            "\n" +
            "<p>2. Tổ chức thực hiện dự toán thu, chi ngân sách được giao; nộp đầy đủ, đúng hạn các khoản phải nộp ngân sách theo quy định của pháp luật; chi đúng chế độ, chính sách, đúng mục đích, đúng đối tượng, bảo đảm tiết kiệm, hiệu quả.</p>\n" +
            "\n" +
            "<p>3. Hướng dẫn, kiểm tra việc thực hiện thu, chi ngân sách đối với các đơn vị trực thuộc.</p>\n" +
            "\n" +
            "<p>4. Chấp hành đúng quy định của pháp luật về kế toán, thống kê; báo cáo, quyết toán ngân sách và công khai ngân sách theo quy định của pháp luật; duyệt quyết toán đối với các đơn vị dự toán cấp dưới.</p>\n" +
            "\n" +
            "<p>5. Đối với đơn vị sự nghiệp công lập, ngoài nhiệm vụ, quyền hạn quy định tại các khoản 1, 2, 3 và 4 Điều này, được chủ động sử dụng nguồn thu phí và các nguồn thu hợp pháp khác để phát triển và nâng cao chất lượng, hiệu quả hoạt động theo quy định của Chính phủ.</p>\n" +
            "\n" +
            "<p>6. Đối với đơn vị sự nghiệp công lập và cơ quan nhà nước thực hiện cơ chế tự chủ, tự chịu trách nhiệm về sử dụng biên chế và kinh phí phải ban hành quy chế chi tiêu nội bộ phù hợp với dự toán được giao tự chủ theo quy định của pháp luật.</p>\n" +
            "\n" +
            "<p>7. Thủ trưởng các đơn vị dự toán ngân sách thực hiện đúng nhiệm vụ, quyền hạn được giao trong lĩnh vực tài chính - ngân sách và chịu trách nhiệm về những sai phạm thuộc phạm vi quản lý theo quy định của pháp luật.</p>\n";
    String dieu34="<p>1. Thực hiện các dự án đầu tư qua các giai đoạn của quá trình đầu tư: chuẩn bị đầu tư, chuẩn bị dự án, thực hiện dự án, nghiệm thu, bàn giao tuân thủ các quy định của pháp luật về quản lý ngân sách nhà nước, đầu tư công, xây dựng và quy định khác của pháp luật có liên quan.</p>\n" +
            "\n" +
            "<p>2. Chấp hành đúng các quy định của pháp luật về hợp đồng, kế toán, thống kê, báo cáo, quyết toán, công khai và lưu trữ hồ sơ dự án.</p>\n";
    String dieu35="<p>1. Nộp đầy đủ, đúng hạn các khoản thuế, phí, lệ phí và các khoản phải nộp khác vào ngân sách nhà nước theo quy định của pháp luật.</p>\n" +
            "\n" +
            "<p>2. Trường hợp được Nhà nước trợ cấp, hỗ trợ vốn và kinh phí theo dự toán được giao thì phải quản lý, sử dụng các khoản vốn và kinh phí đó đúng mục đích, đúng chế độ, tiết kiệm, hiệu quả và quyết toán với cơ quan tài chính.</p>\n" +
            "\n" +
            "<p>3. Chấp hành đúng quy định của pháp luật về kế toán, thống kê và công khai ngân sách.</p>\n" +
            "\n" +
            "<p>4. Được cung cấp thông tin, tham gia giám sát cộng đồng về tài chính - ngân sách theo quy định của pháp luật.</p>";
    String dieu36="";
    String dieu37="<p>1. Các khoản thu ngân sách trung ương hưởng 100%:</p>\n" +
            "\n" +
            "<p>a) Thuế giá trị gia tăng thu từ hàng hóa nhập khẩu;</p>\n" +
            "\n" +
            "<p>b) Thuế xuất khẩu, thuế nhập khẩu;</p>\n" +
            "\n" +
            "<p>c) Thuế tiêu thụ đặc biệt thu từ hàng hóa nhập khẩu;</p>\n" +
            "\n" +
            "<p>d) Thuế bảo vệ môi trường thu từ hàng hóa nhập khẩu;</p>\n" +
            "\n" +
            "<p>đ) Thuế tài nguyên, thuế thu nhập doanh nghiệp, lãi được chia cho nước chủ nhà và các khoản thu khác từ hoạt động thăm dò, khai thác dầu, khí;</p>\n" +
            "\n" +
            "<p>e) Viện trợ không hoàn lại của Chính phủ các nước, các tổ chức quốc tế, các tổ chức khác, các cá nhân ở nước ngoài cho Chính phủ Việt Nam;</p>\n" +
            "\n" +
            "<p>g) Phí thu từ các hoạt động dịch vụ do các cơ quan nhà nước trung ương thực hiện, trường hợp được khoán chi phí hoạt động thì được khấu trừ; các khoản phí thu từ hoạt động dịch vụ do đơn vị sự nghiệp công lập và doanh nghiệp nhà nước trung ương thì được phép trích lại một phần hoặc toàn bộ, phần còn lại thực hiện nộp ngân sách theo quy định của pháp luật về phí, lệ phí và quy định khác của pháp luật có liên quan;</p>\n" +
            "\n" +
            "<p>h) Lệ phí do các cơ quan nhà nước trung ương thu, trừ lệ phí trước bạ quy định tại điểm h khoản 1 Điều 37 của Luật này;</p>\n" +
            "\n" +
            "<p>i) Tiền thu từ xử phạt vi phạm hành chính, phạt, tịch thu khác theo quy định của pháp luật do các cơ quan nhà nước trung ương thực hiện;</p>\n" +
            "\n" +
            "<p>k) Thu từ bán tài sản nhà nước, kể cả thu tiền sử dụng đất gắn với tài sản trên đất do các cơ quan, tổ chức, đơn vị thuộc trung ương quản lý;</p>\n" +
            "\n" +
            "<p>l) Thu từ tài sản được xác lập quyền sở hữu của Nhà nước do các cơ quan, tổ chức, đơn vị thuộc trung ương xử lý;</p>\n" +
            "\n" +
            "<p>m) Các khoản thu hồi vốn của ngân sách trung ương đầu tư tại các tổ chức kinh tế; thu cổ tức, lợi nhuận được chia tại công ty cổ phần, công ty trách nhiệm hữu hạn hai thành viên trở lên có vốn góp của Nhà nước do bộ, cơ quan ngang bộ, cơ quan thuộc Chính phủ, cơ quan khác ở trung ương đại diện chủ sở hữu; thu phần lợi nhuận sau thuế còn lại sau khi trích lập các quỹ của doanh nghiệp nhà nước do bộ, cơ quan ngang bộ, cơ quan thuộc Chính phủ, cơ quan khác ở trung ương đại diện chủ sở hữu; chênh lệch thu lớn hơn chi của Ngân hàng Nhà nước Việt Nam;</p>\n" +
            "\n" +
            "<p>n) Thu từ quỹ dự trữ tài chính trung ương;</p>\n" +
            "\n" +
            "<p>o) Thu kết dư ngân sách trung ương;</p>\n" +
            "\n" +
            "<p>p) Thu chuyển nguồn từ năm trước chuyển sang của ngân sách trung ương;</p>\n" +
            "\n" +
            "<p>q) Các khoản thu khác theo quy định của pháp luật.</p>\n" +
            "\n" +
            "<p>2. Các khoản thu phân chia theo tỷ lệ phần trăm (%) giữa ngân sách trung ương và ngân sách địa phương:</p>\n" +
            "\n" +
            "<p>a) Thuế giá trị gia tăng, trừ thuế giá trị gia tăng quy định tại điểm a khoản 1 Điều này;</p>\n" +
            "\n" +
            "<p>b) Thuế thu nhập doanh nghiệp, trừ thuế thu nhập doanh nghiệp quy định tại điểm đ khoản 1 Điều này;</p>\n" +
            "\n" +
            "<p>c) Thuế thu nhập cá nhân;</p>\n" +
            "\n" +
            "<p>d) Thuế tiêu thụ đặc biệt, trừ thuế tiêu thụ đặc biệt quy định tại điểm c khoản 1 Điều này;</p>\n" +
            "\n" +
            "<p>đ) Thuế bảo vệ môi trường, trừ thuế bảo vệ môi trường quy định tại điểm d khoản 1 Điều này.</p>\n" +
            "\n" +
            "<p>3. Chính phủ quy định chi tiết Điều này.</p>\n";
    String dieu38="<p>1. Chi đầu tư phát triển:</p>\n" +
            "\n" +
            "<p>a) Đầu tư cho các dự án, bao gồm cả các dự án có tính chất liên vùng, khu vực của các bộ, cơ quan ngang bộ, cơ quan thuộc Chính phủ, cơ quan khác ở trung ương theo các lĩnh vực được quy định tại khoản 3 Điều này;</p>\n" +
            "\n" +
            "<p>b) Đầu tư và hỗ trợ vốn cho các doanh nghiệp cung cấp sản phẩm, dịch vụ công ích do Nhà nước đặt hàng; các tổ chức kinh tế; các tổ chức tài chính của trung ương; đầu tư vốn nhà nước vào doanh nghiệp theo quy định của pháp luật;</p>\n" +
            "\n" +
            "<p>c) Các khoản chi đầu tư phát triển khác theo quy định của pháp luật.</p>\n" +
            "\n" +
            "<p>2. Chi dự trữ quốc gia.</p>\n" +
            "\n" +
            "<p>3. Chi thường xuyên của các bộ, cơ quan ngang bộ, cơ quan thuộc Chính phủ, cơ quan khác ở trung ương được phân cấp trong các lĩnh vực:</p>\n" +
            "\n" +
            "<p>a) Quốc phòng;</p>\n" +
            "\n" +
            "<p>b) An ninh và trật tự, an toàn xã hội;</p>\n" +
            "\n" +
            "<p>c) Sự nghiệp giáo dục - đào tạo và dạy nghề;</p>\n" +
            "\n" +
            "<p>d) Sự nghiệp khoa học và công nghệ;</p>\n" +
            "\n" +
            "<p>đ) Sự nghiệp y tế, dân số và gia đình;</p>\n" +
            "\n" +
            "<p>e) Sự nghiệp văn hóa thông tin;</p>\n" +
            "\n" +
            "<p>g) Sự nghiệp phát thanh, truyền hình, thông tấn;</p>\n" +
            "\n" +
            "<p>h) Sự nghiệp thể dục thể thao;</p>\n" +
            "\n" +
            "<p>i) Sự nghiệp bảo vệ môi trường;</p>\n" +
            "\n" +
            "<p>k) Các hoạt động kinh tế;</p>\n" +
            "\n" +
            "<p>l) Hoạt động của các cơ quan quản lý nhà nước, tổ chức chính trị và các tổ chức chính trị - xã hội; hỗ trợ hoạt động cho các tổ chức chính trị xã hội - nghề nghiệp, tổ chức xã hội, tổ chức xã hội - nghề nghiệp theo quy định của pháp luật;</p>\n" +
            "\n" +
            "<p>m) Chi bảo đảm xã hội, bao gồm cả chi hỗ trợ thực hiện các chính sách xã hội theo quy định của pháp luật;</p>\n" +
            "\n" +
            "<p>n) Các khoản chi khác theo quy định của pháp luật.</p>\n" +
            "\n" +
            "<p>4. Chi trả nợ lãi các khoản tiền do Chính phủ vay.</p>\n" +
            "\n" +
            "<p>5. Chi viện trợ.</p>\n" +
            "\n" +
            "<p>6. Chi cho vay theo quy định của pháp luật.</p>\n" +
            "\n" +
            "<p>7. Chi bổ sung quỹ dự trữ tài chính trung ương.</p>\n" +
            "\n" +
            "<p>8. Chi chuyển nguồn của ngân sách trung ương sang năm sau.</p>\n" +
            "\n" +
            "<p>9. Chi bổ sung cân đối ngân sách, bổ sung có mục tiêu cho ngân sách địa phương.</p>";
    String dieu39="<p>1. Các khoản thu ngân sách địa phương hưởng 100%:</p>\n" +
            "\n" +
            "<p>a) Thuế tài nguyên, trừ thuế tài nguyên thu từ hoạt động thăm dò, khai thác dầu, khí;</p>\n" +
            "\n" +
            "<p>b) Thuế môn bài;</p>\n" +
            "\n" +
            "<p>c) Thuế sử dụng đất nông nghiệp;</p>\n" +
            "\n" +
            "<p>d) Thuế sử dụng đất phi nông nghiệp;</p>\n" +
            "\n" +
            "<p>đ) Tiền sử dụng đất, trừ thu tiền sử dụng đất tại điểm k khoản 1 Điều 35 của Luật này;</p>\n" +
            "\n" +
            "<p>e) Tiền cho thuê đất, thuê mặt nước;</p>\n" +
            "\n" +
            "<p>g) Tiền cho thuê và tiền bán nhà ở thuộc sở hữu nhà nước;</p>\n" +
            "\n" +
            "<p>h) Lệ phí trước bạ;</p>\n" +
            "\n" +
            "<p>i) Thu từ hoạt động xổ số kiến thiết;</p>\n" +
            "\n" +
            "<p>k) Các khoản thu hồi vốn của ngân sách địa phương đầu tư tại các tổ chức kinh tế; thu cổ tức, lợi nhuận được chia tại công ty cổ phần, công ty trách nhiệm hữu hạn hai thành viên trở lên có vốn góp của Nhà nước do Ủy ban nhân dân cấp tỉnh đại diện chủ sở hữu; thu phần lợi nhuận sau thuế còn lại sau khi trích lập các quỹ của doanh nghiệp nhà nước do Ủy ban nhân dân cấp tỉnh đại diện chủ sở hữu;</p>\n" +
            "\n" +
            "<p>l) Thu từ quỹ dự trữ tài chính địa phương;</p>\n" +
            "\n" +
            "<p>m) Thu từ bán tài sản nhà nước, kể cả thu tiền sử dụng đất gắn với tài sản trên đất do các cơ quan, tổ chức, đơn vị thuộc địa phương quản lý;</p>\n" +
            "\n" +
            "<p>n) Viện trợ không hoàn lại của các tổ chức quốc tế, các tổ chức khác, các cá nhân ở nước ngoài trực tiếp cho địa phương;</p>\n" +
            "\n" +
            "<p>o) Phí thu từ các hoạt động dịch vụ do các cơ quan nhà nước địa phương thực hiện, trường hợp được khoán chi phí hoạt động thì được khấu trừ; các khoản phí thu từ các hoạt động dịch vụ do đơn vị sự nghiệp công lập và doanh nghiệp nhà nước do Ủy ban nhân dân cấp tỉnh đại diện chủ sở hữu thì được phép trích lại một phần hoặc toàn bộ, phần còn lại thực hiện nộp ngân sách theo quy định của pháp luật về phí, lệ phí và quy định khác của pháp luật có liên quan;</p>\n" +
            "\n" +
            "<p>p) Lệ phí do các cơ quan nhà nước địa phương thực hiện thu;</p>\n" +
            "\n" +
            "<p>q) Tiền thu từ xử phạt vi phạm hành chính, phạt, tịch thu khác theo quy định của pháp luật do các cơ quan nhà nước địa phương thực hiện;</p>\n" +
            "\n" +
            "<p>r) Thu từ tài sản được xác lập quyền sở hữu của Nhà nước do các cơ quan, tổ chức, đơn vị thuộc địa phương xử lý;</p>\n" +
            "\n" +
            "<p>s) Thu từ quỹ đất công ích và thu hoa lợi công sản khác;</p>\n" +
            "\n" +
            "<p>t) Huy động đóng góp từ các cơ quan, tổ chức, cá nhân theo quy định của pháp luật;</p>\n" +
            "\n" +
            "<p>u) Thu kết dư ngân sách địa phương;</p>\n" +
            "\n" +
            "<p>v) Các khoản thu khác theo quy định của pháp luật.</p>\n" +
            "\n" +
            "<p>2. Các khoản thu phân chia theo tỷ lệ phần trăm (%) giữa ngân sách trung ương và ngân sách địa phương theo quy định tại khoản 2 Điều 35 của Luật này.</p>\n" +
            "\n" +
            "<p>3. Thu bổ sung cân đối ngân sách, bổ sung có mục tiêu từ ngân sách trung ương.</p>\n" +
            "\n" +
            "<p>4. Thu chuyển nguồn của ngân sách địa phương từ năm trước chuyển sang.</p>\n";
    String dieu40="<p>1. Chi đầu tư phát triển:</p>\n" +
            "\n" +
            "<p>a) Đầu tư cho các dự án do địa phương quản lý theo các lĩnh vực được quy định tại khoản 2 Điều này;</p>\n" +
            "\n" +
            "<p>b) Đầu tư và hỗ trợ vốn cho các doanh nghiệp cung cấp sản phẩm, dịch vụ công ích do Nhà nước đặt hàng, các tổ chức kinh tế, các tổ chức tài chính của địa phương theo quy định của pháp luật;</p>\n" +
            "\n" +
            "<p>c) Các khoản chi khác theo quy định của pháp luật.</p>\n" +
            "\n" +
            "<p>2. Chi thường xuyên của các cơ quan, đơn vị ở địa phương được phân cấp trong các lĩnh vực:</p>\n" +
            "\n" +
            "<p>a) Sự nghiệp giáo dục - đào tạo và dạy nghề;</p>\n" +
            "\n" +
            "<p>b) Sự nghiệp khoa học và công nghệ;</p>\n" +
            "\n" +
            "<p>c) Quốc phòng, an ninh, trật tự, an toàn xã hội, phần giao địa phương quản lý;</p>\n" +
            "\n" +
            "<p>d) Sự nghiệp y tế, dân số và gia đình;</p>\n" +
            "\n" +
            "<p>đ) Sự nghiệp văn hóa thông tin;</p>\n" +
            "\n" +
            "<p>e) Sự nghiệp phát thanh, truyền hình;</p>\n" +
            "\n" +
            "<p>g) Sự nghiệp thể dục thể thao;</p>\n" +
            "\n" +
            "<p>h) Sự nghiệp bảo vệ môi trường;</p>\n" +
            "\n" +
            "<p>i) Các hoạt động kinh tế;</p>\n" +
            "\n" +
            "<p>k) Hoạt động của các cơ quan quản lý nhà nước, tổ chức chính trị và các tổ chức chính trị - xã hội; hỗ trợ hoạt động cho các tổ chức chính trị xã hội - nghề nghiệp, tổ chức xã hội, tổ chức xã hội - nghề nghiệp theo quy định của pháp luật;</p>\n" +
            "\n" +
            "<p>l) Chi bảo đảm xã hội, bao gồm cả chi thực hiện các chính sách xã hội theo quy định của pháp luật;</p>\n" +
            "\n" +
            "<p>m) Các khoản chi khác theo quy định của pháp luật.</p>\n" +
            "\n" +
            "<p>3. Chi trả nợ lãi các khoản do chính quyền địa phương vay.</p>\n" +
            "\n" +
            "<p>4. Chi bổ sung quỹ dự trữ tài chính địa phương.</p>\n" +
            "\n" +
            "<p>5. Chi chuyển nguồn sang năm sau của ngân sách địa phương.</p>\n" +
            "\n" +
            "<p>6. Chi bổ sung cân đối ngân sách, bổ sung có mục tiêu cho ngân sách cấp dưới.</p>\n" +
            "\n" +
            "<p>7. Chi hỗ trợ thực hiện một số nhiệm vụ quy định tại các điểm a, b và c khoản 9 Điều 9 của Luật này.</p>";
    String dieu41="<p>1. Căn cứ vào nguồn thu, nhiệm vụ chi của ngân sách địa phương quy định tại Điều 37 và Điều 38 của Luật này, Hội đồng nhân dân cấp tỉnh quyết định phân cấp cụ thể nguồn thu, nhiệm vụ chi giữa ngân sách các cấp ở địa phương theo nguyên tắc sau:</p>\n" +
            "\n" +
            "<p>a) Phù hợp với phân cấp nhiệm vụ kinh tế - xã hội, quốc phòng, an ninh đối với từng lĩnh vực và đặc điểm kinh tế, địa lý, dân cư, trình độ quản lý của từng vùng, từng địa phương;</p>\n" +
            "\n" +
            "<p>b) Ngân sách xã, thị trấn được phân chia nguồn thu từ các khoản: thuế sử dụng đất phi nông nghiệp; thuế môn bài thu từ cá nhân, hộ kinh doanh; thuế sử dụng đất nông nghiệp thu từ hộ gia đình; lệ phí trước bạ nhà, đất;</p>\n" +
            "\n" +
            "<p>c) Ngân sách cấp huyện, ngân sách cấp xã không có nhiệm vụ chi nghiên cứu khoa học và công nghệ;</p>\n" +
            "\n" +
            "<p>d) Trong phân cấp nhiệm vụ chi đối với thị xã, thành phố thuộc tỉnh phải có nhiệm vụ chi đầu tư xây dựng các trường phổ thông công lập các cấp, điện chiếu sáng, cấp thoát nước, giao thông đô thị, vệ sinh đô thị và các công trình phúc lợi công cộng khác.</p>\n" +
            "\n" +
            "<p>2. Căn cứ vào tỷ lệ phần trăm (%) đối với các khoản thu phân chia do Chính phủ giao và các nguồn thu ngân sách địa phương hưởng 100%, Hội đồng nhân dân cấp tỉnh quyết định tỷ lệ phần trăm (%) đối với các khoản thu phân chia giữa ngân sách các cấp ở địa phương.</p>\n";
    String dieu42="<p>1. Ngân sách địa phương được sử dụng nguồn thu được hưởng 100%, số thu được phân chia theo tỷ lệ phần trăm (%) đối với các khoản thu phân chia và số bổ sung cân đối từ ngân sách cấp trên để cân đối thu, chi ngân sách cấp mình, bảo đảm các nhiệm vụ kinh tế - xã hội, quốc phòng, an ninh được giao.</p>\n" +
            "\n" +
            "<p>2. Tỷ lệ phần trăm (%) phân chia các khoản thu và số bổ sung cân đối được xác định trên cơ sở:</p>\n" +
            "\n" +
            "<p>a) Tính toán các nguồn thu, nhiệm vụ chi quy định tại các điều 35, 37 và 38 của Luật này theo các chế độ thu ngân sách, nguyên tắc, tiêu chí, định mức phân bổ ngân sách và các chế độ, tiêu chuẩn, định mức chi ngân sách, theo các tiêu chí về dân số, điều kiện tự nhiên, điều kiện kinh tế - xã hội của từng vùng; chú ý tới vùng sâu, vùng xa, vùng căn cứ cách mạng, vùng có đông đồng bào dân tộc thiểu số sinh sống và vùng có khó khăn, vùng đặc biệt khó khăn; vùng có diện tích đất trồng lúa nước lớn; vùng rừng phòng hộ, rừng đặc dụng; vùng kinh tế trọng điểm;</p>\n" +
            "\n" +
            "<p>b) Đối với khoản thu ngân sách địa phương được hưởng theo quy định tại điểm đ và điểm i khoản 1 Điều 37 của Luật này không dùng để xác định tỷ lệ phần trăm (%) đối với các khoản thu phân chia giữa ngân sách trung ương và ngân sách địa phương và xác định số bổ sung cân đối từ ngân sách trung ương cho ngân sách địa phương.</p>\n" +
            "\n" +
            "<p>3. Số bổ sung có mục tiêu từ ngân sách cấp trên cho ngân sách cấp dưới được xác định theo nguyên tắc, tiêu chí, định mức phân bổ ngân sách và các chế độ, tiêu chuẩn, định mức chi ngân sách; khả năng ngân sách cấp trên và khả năng cân đối ngân sách của từng địa phương cấp dưới, để hỗ trợ ngân sách cấp dưới trong các trường hợp sau:</p>\n" +
            "\n" +
            "<p>a) Thực hiện các chính sách, chế độ mới do cấp trên ban hành chưa được bố trí trong dự toán ngân sách của năm đầu thời kỳ ổn định ngân sách;</p>\n" +
            "\n" +
            "<p>b) Thực hiện các chương trình mục tiêu quốc gia và các chương trình, dự án khác của cấp trên, phần giao cho cấp dưới thực hiện;</p>\n" +
            "\n" +
            "<p>c) Hỗ trợ chi khắc phục thiên tai, thảm họa, dịch bệnh trên diện rộng vượt quá khả năng cân đối của ngân sách cấp dưới;</p>\n" +
            "\n" +
            "<p>d) Hỗ trợ thực hiện một số chương trình, dự án lớn, đặc biệt quan trọng có tác động lớn đến phát triển kinh tế - xã hội của địa phương. Mức hỗ trợ được xác định cụ thể cho từng chương trình, dự án. Tổng mức hỗ trợ vốn đầu tư phát triển hằng năm của ngân sách trung ương cho ngân sách địa phương quy định tại điểm này tối đa không vượt quá 30% tổng chi đầu tư xây dựng cơ bản của ngân sách trung ương.</p>\n";
    String dieu43="";
    String dieu44="<p>1. Nhiệm vụ phát triển kinh tế - xã hội và bảo đảm quốc phòng, an ninh, đối ngoại, bình đẳng giới.</p>\n" +
            "\n" +
            "<p>2. Nhiệm vụ cụ thể của các bộ, cơ quan ngang bộ, cơ quan thuộc Chính phủ, cơ quan, tổ chức khác ở trung ương, các cơ quan, tổ chức, đơn vị ở địa phương.</p>\n" +
            "\n" +
            "<p>3. Quy định của pháp luật về thuế, phí, lệ phí và chế độ thu ngân sách nhà nước; định mức phân bổ ngân sách, chế độ, tiêu chuẩn, định mức chi ngân sách nhà nước.</p>\n" +
            "\n" +
            "<p>4. Phân cấp nguồn thu, nhiệm vụ chi ngân sách và tỷ lệ phần trăm (%) phân chia đối với các khoản thu phân chia và mức bổ sung cân đối ngân sách của ngân sách cấp trên cho ngân sách cấp dưới.</p>\n" +
            "\n" +
            "<p>5. Văn bản pháp luật của các cấp, cơ quan nhà nước có thẩm quyền hướng dẫn xây dựng kế hoạch phát triển kinh tế - xã hội và dự toán ngân sách nhà nước năm sau.</p>\n" +
            "\n" +
            "<p>6. Kế hoạch tài chính 05 năm, kế hoạch tài chính - ngân sách nhà nước 03 năm, kế hoạch đầu tư trung hạn nguồn ngân sách nhà nước.</p>\n" +
            "\n" +
            "<p>7. Tình hình thực hiện ngân sách nhà nước năm trước.</p>\n" +
            "\n" +
            "<p>8. Số kiểm tra dự toán thu, chi ngân sách thông báo cho các cấp, các cơ quan, tổ chức, đơn vị có liên quan.</p>";
    String dieu45="<p>1. Dự toán ngân sách nhà nước phải tổng hợp theo từng khoản thu, chi và theo cơ cấu chi đầu tư phát triển, chi thường xuyên, chi dự trữ quốc gia, chi trả nợ và viện trợ, chi bổ sung quỹ dự trữ tài chính, dự phòng ngân sách.</p>\n" +
            "\n" +
            "<p>2. Dự toán ngân sách của đơn vị dự toán ngân sách các cấp được lập phải thể hiện đầy đủ các khoản thu, chi theo đúng biểu mẫu, thời hạn do cơ quan nhà nước có thẩm quyền quy định. Trong đó:</p>\n" +
            "\n" +
            "<p>a) Dự toán thu ngân sách được lập trên cơ sở dự báo các chỉ tiêu kinh tế vĩ mô và các chỉ tiêu có liên quan, các quy định của pháp luật về thuế, phí, lệ phí và chế độ thu ngân sách;</p>\n" +
            "\n" +
            "<p>b) Dự toán chi đầu tư phát triển được lập trên cơ sở quy hoạch, kế hoạch, chương trình, dự án đã được cấp có thẩm quyền phê duyệt; kế hoạch tài chính 05 năm, kế hoạch đầu tư trung hạn nguồn ngân sách nhà nước, khả năng cân đối các nguồn lực trong năm dự toán, quy định của pháp luật về đầu tư công, xây dựng và quy định khác của pháp luật có liên quan;</p>\n" +
            "\n" +
            "<p>c) Dự toán chi thường xuyên được lập trên cơ sở nhiệm vụ được giao, nhiệm vụ được cơ quan có thẩm quyền phê duyệt, chế độ, tiêu chuẩn, định mức chi do cơ quan nhà nước có thẩm quyền quy định. Việc lập dự toán ngân sách của các cơ quan nhà nước thực hiện chế độ tự chủ, tự chịu trách nhiệm về sử dụng biên chế và kinh phí quản lý hành chính; đơn vị sự nghiệp công lập thực hiện quyền tự chủ, tự chịu trách nhiệm về thực hiện nhiệm vụ, tổ chức bộ máy, biên chế và tài chính thực hiện theo quy định của Chính phủ;</p>\n" +
            "\n" +
            "<p>d) Dự toán chi ngân sách nhà nước đối với lĩnh vực giáo dục - đào tạo và dạy nghề, khoa học và công nghệ bảo đảm tỷ lệ theo quy định của pháp luật có liên quan;</p>\n" +
            "\n" +
            "<p>đ) Dự toán chi thực hiện các chương trình mục tiêu quốc gia được lập căn cứ vào danh mục các chương trình, tổng mức kinh phí thực hiện chương trình mục tiêu quốc gia trong từng giai đoạn do Quốc hội quyết định, mục tiêu, nội dung, nhiệm vụ và chi tiết các dự án thành phần đối với từng chương trình mục tiêu quốc gia;</p>\n" +
            "\n" +
            "<p>e) Dự toán chi trả nợ được lập trên cơ sở bảo đảm trả các khoản nợ đến hạn của năm dự toán ngân sách;</p>\n" +
            "\n" +
            "<p>g) Dự toán vay bù đắp bội chi ngân sách nhà nước phải căn cứ vào cân đối ngân sách nhà nước, khả năng từng nguồn vay, khả năng trả nợ và trong giới hạn an toàn về nợ theo nghị quyết của Quốc hội.</p>\n";
    String dieu46="<p>1. Kế hoạch tài chính - ngân sách nhà nước 03 năm là kế hoạch tài chính - ngân sách nhà nước được lập hằng năm cho thời gian 03 năm, trên cơ sở kế hoạch tài chính 05 năm, được lập kể từ năm dự toán ngân sách và 02 năm tiếp theo, theo phương thức cuốn chiếu. Kế hoạch này được lập cùng thời điểm lập dự toán ngân sách nhà nước hằng năm nhằm định hướng cho công tác lập dự toán ngân sách nhà nước hằng năm; định hướng thứ tự ưu tiên phân bổ nguồn lực cho từng lĩnh vực và từng nhiệm vụ, hoạt động, chế độ, chính sách cho từng lĩnh vực trong trung hạn.</p>\n" +
            "\n" +
            "<p>2. Kế hoạch tài chính - ngân sách nhà nước 03 năm gồm kế hoạch tài chính - ngân sách nhà nước 03 năm quốc gia và kế hoạch tài chính - ngân sách nhà nước 03 năm tỉnh, thành phố trực thuộc trung ương. Nội dung gồm: dự báo về các chỉ tiêu kinh tế vĩ mô, những chính sách ngân sách quan trọng; dự báo về số thu, chi và cơ cấu thu, chi; dự báo về số bội chi ngân sách; xác định các nguyên tắc cân đối ngân sách nhà nước và thứ tự ưu tiên phân bổ nguồn lực ngân sách, trần chi tiêu cho các lĩnh vực, nhiệm vụ chi đầu tư phát triển, chi trả nợ, chi thường xuyên; dự báo về nghĩa vụ nợ dự phòng và các giải pháp chủ yếu để thực hiện kế hoạch trong thời hạn 03 năm.</p>\n" +
            "\n" +
            "<p>3. Các bộ, cơ quan ngang bộ, cơ quan thuộc Chính phủ, cơ quan khác ở trung ương, các cơ quan, đơn vị ở cấp tỉnh lập kế hoạch tài chính - ngân sách nhà nước 03 năm, nội dung gồm: mục tiêu, nhiệm vụ, chế độ, chính sách chủ yếu của ngành, cơ quan, đơn vị; dự báo các nguồn lực tài chính, trong đó dự báo về số thu được giao quản lý, yêu cầu về chi ngân sách để thực hiện; thể hiện nguyên tắc và cách thức xác định, sắp xếp thứ tự ưu tiên thực hiện các nhiệm vụ, hoạt động, chế độ, chính sách và dự kiến phân bổ kinh phí trong tổng mức trần chi tiêu được cơ quan có thẩm quyền xác định trước; các giải pháp chủ yếu để cân đối giữa nhu cầu chi ngân sách và trần chi tiêu trong thời hạn 03 năm.</p>\n" +
            "\n" +
            "<p>4. Bộ Tài chính chủ trì, phối hợp với Bộ Kế hoạch và Đầu tư tổng hợp kế hoạch tài chính - ngân sách nhà nước 03 năm quốc gia, báo cáo Chính phủ trình Quốc hội; Sở Tài chính chủ trì, phối hợp với Sở Kế hoạch và Đầu tư tổng hợp kế hoạch tài chính - ngân sách nhà nước 03 năm tỉnh, thành phố trực thuộc trung ương báo cáo Ủy ban nhân dân cấp tỉnh trình Hội đồng nhân dân cùng cấp để tham khảo khi thảo luận, xem xét, thông qua dự toán ngân sách và phương án phân bổ ngân sách nhà nước hằng năm.</p>\n" +
            "\n" +
            "<p>5. Chính phủ quy định việc lập kế hoạch tài chính - ngân sách nhà nước 03 năm.</p>\n";
    String dieu47="<p>1. Trước ngày 15 tháng 5, Thủ tướng Chính phủ ban hành quy định về việc xây dựng kế hoạch phát triển kinh tế - xã hội, dự toán ngân sách nhà nước năm sau.</p>\n" +
            "\n" +
            "<p>2. Trước ngày 20 tháng 9, Chính phủ trình các tài liệu báo cáo theo quy định tại khoản 1 Điều 47 của Luật này đến Ủy ban thường vụ Quốc hội để cho ý kiến.</p>\n" +
            "\n" +
            "<p>3. Các báo cáo của Chính phủ được gửi đến các đại biểu Quốc hội chậm nhất là 20 ngày trước ngày khai mạc kỳ họp Quốc hội cuối năm.</p>\n" +
            "\n" +
            "<p>4. Trước ngày 15 tháng 11, Quốc hội quyết định dự toán ngân sách nhà nước, phương án phân bổ ngân sách trung ương năm sau.</p>\n" +
            "\n" +
            "<p>5. Trước ngày 20 tháng 11, Thủ tướng Chính phủ giao dự toán thu, chi ngân sách năm sau cho từng bộ, cơ quan ngang bộ, cơ quan thuộc Chính phủ, cơ quan khác ở trung ương và từng tỉnh, thành phố trực thuộc trung ương.</p>\n" +
            "\n" +
            "<p>6. Trước ngày 10 tháng 12, Hội đồng nhân dân cấp tỉnh quyết định dự toán ngân sách địa phương, phân bổ ngân sách cấp tỉnh năm sau. Hội đồng nhân dân cấp dưới quyết định dự toán ngân sách địa phương, phân bổ ngân sách năm sau của cấp mình chậm nhất là 10 ngày, kể từ ngày Hội đồng nhân dân cấp trên trực tiếp quyết định dự toán và phân bổ ngân sách.</p>\n" +
            "\n" +
            "<p>7. Chậm nhất là 05 ngày làm việc, kể từ ngày Hội đồng nhân dân quyết định dự toán ngân sách, Ủy ban nhân dân cùng cấp giao dự toán ngân sách năm sau cho từng cơ quan, đơn vị thuộc cấp mình và cấp dưới; đồng thời, báo cáo Ủy ban nhân dân và cơ quan tài chính cấp trên trực tiếp, Ủy ban nhân dân cấp tỉnh báo cáo Bộ Tài chính về dự toán ngân sách đã được Hội đồng nhân dân cấp tỉnh quyết định.</p>\n" +
            "\n" +
            "<p>8. Trước ngày 31 tháng 12, các bộ, cơ quan ngang bộ, cơ quan thuộc Chính phủ, cơ quan khác ở trung ương, Ủy ban nhân dân các cấp phải hoàn thành việc giao dự toán ngân sách cho từng cơ quan, đơn vị trực thuộc và Ủy ban nhân dân cấp dưới.</p>\n";
    String dieu48="<p>1. Cơ quan thu các cấp ở địa phương xây dựng dự toán thu ngân sách nhà nước trên địa bàn gửi cơ quan thu cấp trên, cơ quan tài chính cùng cấp. Cơ quan thu ở trung ương xây dựng dự toán thu ngân sách nhà nước theo lĩnh vực được giao phụ trách, gửi Bộ Tài chính để tổng hợp, lập dự toán ngân sách nhà nước.</p>\n" +
            "\n" +
            "<p>2. Cơ quan, tổ chức, đơn vị, chủ đầu tư lập dự toán thu, chi ngân sách trong phạm vi nhiệm vụ được giao, báo cáo cơ quan quản lý cấp trên để tổng hợp báo cáo cơ quan tài chính cùng cấp.</p>\n" +
            "\n" +
            "<p>3. Cơ quan tài chính các cấp ở địa phương xem xét dự toán ngân sách của các cơ quan, tổ chức, đơn vị cùng cấp, dự toán ngân sách địa phương cấp dưới; chủ trì phối hợp với cơ quan liên quan trong việc tổng hợp, lập dự toán ngân sách địa phương, phương án phân bổ ngân sách cấp mình theo các chỉ tiêu quy định tại khoản 1 và khoản 2 Điều 30 của Luật này, báo cáo Ủy ban nhân dân cùng cấp.</p>\n" +
            "\n" +
            "<p>4. Ủy ban nhân dân các cấp tổng hợp, lập dự toán ngân sách địa phương báo cáo Thường trực Hội đồng nhân dân cùng cấp xem xét, cho ý kiến. Ủy ban nhân dân cấp tỉnh gửi Bộ Tài chính, Bộ Kế hoạch và Đầu tư và các cơ quan theo quy định để tổng hợp, lập dự toán ngân sách nhà nước trình Chính phủ; đồng thời gửi đến Đoàn đại biểu Quốc hội để giám sát.</p>\n" +
            "\n" +
            "<p>5. Các cơ quan quản lý ngành, lĩnh vực ở trung ương và địa phương phối hợp với cơ quan tài chính, cơ quan kế hoạch và đầu tư cùng cấp lập dự toán ngân sách nhà nước theo ngành, lĩnh vực được giao phụ trách.</p>\n" +
            "\n" +
            "<p>6. Bộ Tài chính xem xét dự toán ngân sách của các bộ, cơ quan ngang bộ, cơ quan thuộc Chính phủ, cơ quan khác ở trung ương và địa phương; chủ trì, phối hợp với Bộ Kế hoạch và Đầu tư, các bộ, ngành có liên quan trong việc tổng hợp, lập dự toán ngân sách nhà nước, phương án phân bổ ngân sách trung ương trình Chính phủ theo các nội dung quy định tại khoản 1 Điều 47 của Luật này.</p>\n";
    String dieu49="<p>1. Các bộ, cơ quan ngang bộ, cơ quan thuộc Chính phủ, cơ quan khác ở trung ương và các cơ quan, đơn vị ở địa phương tổ chức thảo luận với các cơ quan, đơn vị trực thuộc.</p>\n" +
            "\n" +
            "<p>2. Cơ quan tài chính các cấp chủ trì tổ chức:</p>\n" +
            "\n" +
            "<p>a) Thảo luận về dự toán ngân sách hằng năm với các cơ quan, đơn vị cùng cấp;</p>\n" +
            "\n" +
            "<p>b) Thảo luận về dự toán ngân sách năm đầu thời kỳ ổn định ngân sách với Ủy ban nhân dân cấp dưới trực tiếp để xác định tỷ lệ phần trăm (%) phân chia các khoản thu phân chia giữa ngân sách cấp trên và ngân sách cấp dưới, số bổ sung cân đối từ ngân sách cấp trên cho ngân sách cấp dưới để làm cơ sở xây dựng dự toán ngân sách các năm sau;</p>\n" +
            "\n" +
            "<p>c) Đối với các năm tiếp theo của thời kỳ ổn định ngân sách, cơ quan tài chính tổ chức làm việc với Ủy ban nhân dân cấp dưới trực tiếp khi Ủy ban nhân dân cấp đó đề nghị.</p>\n" +
            "\n" +
            "<p>3. Trong quá trình thảo luận dự toán ngân sách, phương án phân bổ ngân sách, trường hợp có những khoản thu, chi trong dự toán chưa đúng quy định của pháp luật, chưa phù hợp với khả năng ngân sách và định hướng phát triển kinh tế - xã hội thì cơ quan tài chính yêu cầu điều chỉnh lại, nếu còn ý kiến khác nhau giữa cơ quan tài chính với các cơ quan, đơn vị cùng cấp và Ủy ban nhân dân cấp dưới thì cơ quan tài chính ở địa phương báo cáo Ủy ban nhân dân cùng cấp quyết định; Bộ Tài chính báo cáo Thủ tướng Chính phủ quyết định.</p>\n" +
            "\n" +
            "<p>4. Thẩm tra, trình Quốc hội quyết định dự toán ngân sách nhà nước và phương án phân bổ ngân sách trung ương:</p>\n" +
            "\n" +
            "<p>a) Chính phủ thảo luận, cho ý kiến vào dự thảo các báo cáo của Chính phủ do Bộ Tài chính trình trước khi trình Ủy ban thường vụ Quốc hội;</p>\n" +
            "\n" +
            "<p>b) Ủy ban tài chính, ngân sách của Quốc hội chủ trì thẩm tra các báo cáo của Chính phủ trình Ủy ban thường vụ Quốc hội, Quốc hội;</p>\n" +
            "\n" +
            "<p>c) Trên cơ sở ý kiến thẩm tra của Ủy ban tài chính, ngân sách của Quốc hội và ý kiến của Ủy ban thường vụ Quốc hội, Chính phủ hoàn chỉnh các báo cáo trình Quốc hội;</p>\n" +
            "\n" +
            "<p>d) Quốc hội thảo luận, quyết định dự toán ngân sách nhà nước, phương án phân bổ ngân sách trung ương năm sau. Trong quá trình thảo luận, quyết định dự toán ngân sách nhà nước, phương án phân bổ ngân sách trung ương, trường hợp quyết định điều chỉnh thu, chi ngân sách, Quốc hội quyết định các giải pháp để bảo đảm cân đối ngân sách.</p>\n" +
            "\n" +
            "<p>5. Trình tự, thủ tục thẩm tra của các cơ quan của Quốc hội về dự toán ngân sách nhà nước, phương án phân bổ ngân sách trung ương do Ủy ban thường vụ Quốc hội quy định.</p>\n" +
            "\n" +
            "<p>6. Việc xem xét, quyết định dự toán ngân sách địa phương và phương án phân bổ ngân sách địa phương thực hiện theo quy định của Chính phủ.</p>\n";
    String dieu50="<p>1. Tài liệu Chính phủ trình Quốc hội về dự toán ngân sách nhà nước và phương án phân bổ ngân sách trung ương gồm:</p>\n" +
            "\n" +
            "<p>a) Đánh giá tình hình thực hiện ngân sách nhà nước năm hiện hành; các căn cứ xây dựng dự toán ngân sách nhà nước và phân bổ ngân sách trung ương; những nội dung cơ bản và giải pháp nhằm thực hiện dự toán ngân sách nhà nước;</p>\n" +
            "\n" +
            "<p>b) Dự toán thu ngân sách nhà nước, kèm theo các giải pháp nhằm huy động nguồn thu cho ngân sách nhà nước;</p>\n" +
            "\n" +
            "<p>c) Dự toán chi ngân sách nhà nước, trong đó nêu rõ các mục tiêu, chương trình quan trọng của nền kinh tế quốc dân và các chính sách lớn của Đảng và Nhà nước có liên quan đến ngân sách nhà nước;</p>\n" +
            "\n" +
            "<p>d) Bội chi ngân sách nhà nước và các nguồn bù đắp; tỷ lệ bội chi so với tổng sản phẩm trong nước;</p>\n" +
            "\n" +
            "<p>đ) Kế hoạch tài chính 05 năm đối với năm đầu kỳ kế hoạch;</p>\n" +
            "\n" +
            "<p>e) Kế hoạch tài chính - ngân sách nhà nước 03 năm;</p>\n" +
            "\n" +
            "<p>g) Báo cáo thông tin về nợ công theo Luật quản lý nợ công, trong đó nêu rõ số nợ đến hạn phải trả, số nợ quá hạn phải trả, số lãi phải trả trong năm, số nợ sẽ phát sinh thêm do phải vay để bù đắp bội chi ngân sách nhà nước, khả năng trả nợ trong năm và số nợ đến cuối năm;</p>\n" +
            "\n" +
            "<p>h) Báo cáo tình hình thực hiện kế hoạch tài chính, dự kiến kế hoạch tài chính năm sau của các quỹ tài chính nhà nước ngoài ngân sách do trung ương quản lý;</p>\n" +
            "\n" +
            "<p>i) Các chính sách và biện pháp cụ thể nhằm ổn định tài chính và ngân sách nhà nước;</p>\n" +
            "\n" +
            "<p>k) Danh mục, tiến độ thực hiện và mức dự toán đầu tư năm kế hoạch đối với các chương trình, dự án quan trọng quốc gia sử dụng vốn ngân sách nhà nước đã được Quốc hội quyết định;</p>\n" +
            "\n" +
            "<p>l) Dự toán chi của từng bộ, cơ quan ngang bộ, cơ quan thuộc Chính phủ, cơ quan khác ở trung ương theo từng lĩnh vực; nhiệm vụ thu, chi, mức bội chi, tỷ lệ phần trăm (%) phân chia đối với các khoản thu phân chia và số bổ sung từ ngân sách trung ương cho ngân sách từng tỉnh, thành phố trực thuộc trung ương;</p>\n" +
            "\n" +
            "<p>m) Các tài liệu khác nhằm thuyết minh rõ dự toán thu, chi ngân sách nhà nước và phương án phân bổ ngân sách trung ương; tình hình miễn, giảm thuế trong báo cáo dự toán ngân sách nhà nước trình Quốc hội.</p>\n" +
            "\n" +
            "<p>2. Chính phủ quy định tài liệu Ủy ban nhân dân trình Hội đồng nhân dân cùng cấp về dự toán ngân sách và phương án phân bổ ngân sách địa phương.</p>\n";
    String dieu51="\n" +
            "<p>1. Trong trường hợp dự toán ngân sách nhà nước, phương án phân bổ ngân sách trung ương chưa được Quốc hội quyết định, Chính phủ lập lại dự toán ngân sách nhà nước, phương án phân bổ ngân sách trung ương trình Quốc hội vào thời gian do Quốc hội quyết định.</p>\n" +
            "\n" +
            "<p>2. Trường hợp dự toán ngân sách địa phương, phương án phân bổ ngân sách cấp mình chưa được Hội đồng nhân dân quyết định, Ủy ban nhân dân lập lại dự toán ngân sách địa phương, phương án phân bổ ngân sách cấp mình, trình Hội đồng nhân dân vào thời gian do Hội đồng nhân dân quyết định, nhưng không được chậm hơn thời hạn Chính phủ quy định.</p>\n";
    String dieu52="";
    String dieu53="<p>1. Sau khi được Chính phủ, Ủy ban nhân dân giao dự toán ngân sách, các đơn vị dự toán cấp I ở trung ương và địa phương thực hiện phân bổ và giao dự toán ngân sách cho các đơn vị sử dụng ngân sách trực thuộc và đơn vị thuộc ngân sách cấp dưới trong trường hợp có ủy quyền thực hiện nhiệm vụ chi của mình, gửi cơ quan tài chính cùng cấp, đồng thời gửi Kho bạc Nhà nước nơi giao dịch để thực hiện. Việc phân bổ và giao dự toán phải bảo đảm thời hạn và yêu cầu quy định tại Điều 50 của Luật này.</p>\n" +
            "\n" +
            "<p>2. Cơ quan tài chính cùng cấp thực hiện kiểm tra dự toán đơn vị dự toán cấp I đã giao cho các đơn vị sử dụng ngân sách. Trường hợp phát hiện việc phân bổ không đúng tổng mức và chi tiết theo từng lĩnh vực, nhiệm vụ của dự toán ngân sách đã được giao; không đúng chính sách, chế độ quy định thì yêu cầu đơn vị dự toán cấp I điều chỉnh lại chậm nhất là 10 ngày làm việc, kể từ ngày nhận được báo cáo phân bổ của đơn vị dự toán ngân sách.</p>\n" +
            "\n" +
            "<p>3. Ngoài cơ quan có thẩm quyền giao dự toán ngân sách, không tổ chức hoặc cá nhân nào được thay đổi nhiệm vụ ngân sách đã được giao.</p>\n";
    String dieu54="<p>1. Việc phân bổ và giao dự toán cho các đơn vị sử dụng ngân sách phải bảo đảm:</p>\n" +
            "\n" +
            "<p>a) Đúng với dự toán ngân sách được giao cả về tổng mức và chi tiết theo từng lĩnh vực, nhiệm vụ thu, chi được giao;</p>\n" +
            "\n" +
            "<p>b) Đúng chính sách, chế độ, tiêu chuẩn, định mức chi;</p>\n" +
            "\n" +
            "<p>c) Phân bổ đủ vốn, kinh phí để thu hồi các khoản đã ứng trước dự toán đến hạn thu hồi trong năm, vốn đối ứng các dự án sử dụng vốn hỗ trợ phát triển chính thức (ODA) của các nhà tài trợ nước ngoài theo cam kết;</p>\n" +
            "\n" +
            "<p>d) Đối với phân bổ vốn đầu tư phát triển phải bảo đảm các yêu cầu theo quy định của pháp luật về đầu tư công, xây dựng và quy định khác của pháp luật có liên quan;</p>\n" +
            "\n" +
            "<p>đ) Đối với phân bổ các khoản bổ sung có mục tiêu từ ngân sách cấp trên cho ngân sách cấp dưới phải bảo đảm đúng mục tiêu, đúng đối tượng và thực hiện đúng các cam kết hoặc quy định về bố trí ngân sách địa phương cho mục tiêu đó.</p>\n" +
            "\n" +
            "<p>2. Thời hạn phân bổ và giao dự toán ngân sách nhà nước:</p>\n" +
            "\n" +
            "<p>a) Đối với dự toán ngân sách được giao theo quy định tại khoản 5 và khoản 7 Điều 44 của Luật này, các đơn vị dự toán cấp I phải hoàn thành việc phân bổ và giao dự toán cho các đơn vị sử dụng ngân sách trực thuộc trước ngày 31 tháng 12 năm trước theo quy định tại khoản 8 Điều 44 của Luật này;</p>\n" +
            "\n" +
            "<p>b) Trường hợp được giao bổ sung dự toán, chậm nhất 10 ngày làm việc, kể từ ngày được giao dự toán bổ sung, đơn vị dự toán cấp trên, Ủy ban nhân dân cấp dưới phải hoàn thành việc phân bổ và giao dự toán theo quy định.</p>\n";
    String dieu55="<p>1. Trong trường hợp vào đầu năm ngân sách, dự toán ngân sách và phương án phân bổ ngân sách chưa được Quốc hội, Hội đồng nhân dân quyết định, cơ quan tài chính và cơ quan Kho bạc Nhà nước các cấp theo chức năng thực hiện tạm cấp ngân sách cho các nhiệm vụ chi không thể trì hoãn được cho đến khi dự toán ngân sách được cấp có thẩm quyền quyết định:</p>\n" +
            "\n" +
            "<p>a) Chi lương và các khoản có tính chất tiền lương;</p>\n" +
            "\n" +
            "<p>b) Chi nghiệp vụ phí và công vụ phí;</p>\n" +
            "\n" +
            "<p>c) Chi bổ sung cân đối cho ngân sách cấp dưới;</p>\n" +
            "\n" +
            "<p>d) Một số khoản chi cần thiết khác để bảo đảm hoạt động của bộ máy nhà nước, trừ các khoản mua sắm trang thiết bị, sửa chữa;</p>\n" +
            "\n" +
            "<p>đ) Chi cho dự án chuyển tiếp thuộc các chương trình mục tiêu quốc gia, dự án quan trọng quốc gia; các dự án đầu tư chuyển tiếp quan trọng, cấp bách khác để khắc phục hậu quả thiên tai, thảm họa, dịch bệnh.</p>\n" +
            "\n" +
            "<p>2. Mức tạm cấp hàng tháng tối đa cho các nhiệm vụ quy định tại các điểm a, b, c và d khoản 1 Điều này không quá mức chi bình quân 01 tháng của năm trước.</p>\n" +
            "\n" +
            "<p>3. Chi đầu tư các chương trình, dự án sử dụng vốn ODA và vốn vay ưu đãi từ nhà tài trợ chưa được dự toán hoặc vượt so với dự toán được giao, Chính phủ báo cáo Ủy ban thường vụ Quốc hội cho ý kiến trước khi thực hiện và báo cáo Quốc hội tại kỳ họp gần nhất.</p>\n";
    String dieu56="<p>1. Điều chỉnh tổng thể ngân sách nhà nước trong trường hợp có biến động về ngân sách so với dự toán đã phân bổ cần phải điều chỉnh tổng thể:</p>\n" +
            "\n" +
            "<p>a) Chính phủ lập dự toán điều chỉnh tổng thể ngân sách nhà nước trình Quốc hội quyết định;</p>\n" +
            "\n" +
            "<p>b) Căn cứ vào nghị quyết của Quốc hội về dự toán điều chỉnh tổng thể ngân sách nhà nước và nhiệm vụ thu, chi ngân sách được cấp trên giao, Ủy ban nhân dân các cấp lập dự toán điều chỉnh tổng thể ngân sách địa phương trình Hội đồng nhân dân cùng cấp quyết định.</p>\n" +
            "\n" +
            "<p>2. Chính phủ trình Ủy ban thường vụ Quốc hội quyết định điều chỉnh nhiệm vụ thu, chi của một số bộ, cơ quan ngang bộ, cơ quan thuộc Chính phủ, cơ quan khác ở trung ương và một số tỉnh, thành phố trực thuộc trung ương và báo cáo Quốc hội tại kỳ họp gần nhất trong các trường hợp sau:</p>\n" +
            "\n" +
            "<p>a) Dự kiến số thu không đạt dự toán được Quốc hội quyết định phải điều chỉnh giảm một số khoản chi;</p>\n" +
            "\n" +
            "<p>b) Có yêu cầu cấp bách về quốc phòng, an ninh hoặc vì lý do khách quan cần phải điều chỉnh.</p>\n" +
            "\n" +
            "<p>3. Ủy ban nhân dân trình Thường trực Hội đồng nhân dân cùng cấp quyết định điều chỉnh dự toán ngân sách địa phương và báo cáo Hội đồng nhân dân tại kỳ họp gần nhất trong các trường hợp sau:</p>\n" +
            "\n" +
            "<p>a) Dự kiến số thu không đạt dự toán được Hội đồng nhân dân quyết định phải điều chỉnh giảm một số khoản chi;</p>\n" +
            "\n" +
            "<p>b) Ủy ban thường vụ Quốc hội quyết định điều chỉnh dự toán ngân sách của một số tỉnh, thành phố trực thuộc trung ương theo quy định tại khoản 2 Điều này;</p>\n" +
            "\n" +
            "<p>c) Khi cần điều chỉnh dự toán ngân sách của một số đơn vị dự toán hoặc địa phương cấp dưới.</p>\n" +
            "\n" +
            "<p>4. Chính phủ yêu cầu Hội đồng nhân dân cấp tỉnh điều chỉnh dự toán ngân sách nếu việc bố trí ngân sách địa phương không phù hợp với nghị quyết của Quốc hội.</p>\n" +
            "\n" +
            "<p>5. Ủy ban nhân dân yêu cầu Hội đồng nhân dân cấp dưới điều chỉnh dự toán ngân sách nếu việc bố trí ngân sách địa phương không phù hợp với nghị quyết của Hội đồng nhân dân cấp trên.</p>\n";
    String dieu57="<p>1. Điều chỉnh dự toán ngân sách đã giao cho các đơn vị sử dụng ngân sách trực thuộc trong các trường hợp:</p>\n" +
            "\n" +
            "<p>a) Do điều chỉnh dự toán ngân sách theo quy định tại Điều 52 của Luật này;</p>\n" +
            "\n" +
            "<p>b) Cơ quan tài chính yêu cầu đơn vị dự toán cấp I điều chỉnh lại dự toán theo quy định tại khoản 2 Điều 49 của Luật này;</p>\n" +
            "\n" +
            "<p>c) Đơn vị dự toán cấp I điều chỉnh dự toán giữa các đơn vị trực thuộc trong phạm vi tổng mức và chi tiết theo từng lĩnh vực chi được giao.</p>\n" +
            "\n" +
            "<p>2. Việc điều chỉnh dự toán phải bảo đảm các yêu cầu về phân bổ và giao dự toán quy định tại khoản 1 Điều 50 của Luật này. Sau khi thực hiện điều chỉnh dự toán, đơn vị dự toán cấp I gửi cơ quan tài chính cùng cấp để kiểm tra, đồng thời gửi Kho bạc Nhà nước nơi giao dịch để thực hiện.</p>\n" +
            "\n" +
            "<p>3. Thời gian điều chỉnh dự toán đã giao cho các đơn vị sử dụng ngân sách hoàn thành trước ngày 15 tháng 11 năm hiện hành.</p>\n";
    String dieu58="<p>1. Các cơ quan, tổ chức, đơn vị, cá nhân trong phạm vi nhiệm vụ, quyền hạn của mình có trách nhiệm đề ra những biện pháp cần thiết nhằm bảo đảm hoàn thành nhiệm vụ thu, chi ngân sách được giao, thực hiện tiết kiệm, chống lãng phí, chống tham nhũng; chấp hành nghiêm kỷ cương, kỷ luật tài chính.</p>\n" +
            "\n" +
            "<p>2. Mọi cơ quan, tổ chức, đơn vị, cá nhân phải chấp hành nghĩa vụ nộp ngân sách theo đúng quy định của pháp luật; sử dụng kinh phí ngân sách đúng mục đích, đúng chế độ, tiết kiệm, hiệu quả.</p>\n" +
            "\n" +
            "<p>3. Cơ quan tài chính có trách nhiệm bảo đảm nguồn để thanh toán kịp thời các khoản chi theo dự toán.</p>\n";
    String dieu59="<p>1. Cơ quan thu ngân sách là cơ quan tài chính, cơ quan thuế, cơ quan hải quan và cơ quan khác được cơ quan nhà nước có thẩm quyền giao hoặc ủy quyền tổ chức thực hiện nhiệm vụ thu ngân sách nhà nước.</p>\n" +
            "\n" +
            "<p>2. Chỉ cơ quan thu ngân sách được tổ chức thu ngân sách.</p>\n" +
            "\n" +
            "<p>3. Cơ quan thu ngân sách có nhiệm vụ, quyền hạn sau đây:</p>\n" +
            "\n" +
            "<p>a) Phối hợp với các cơ quan nhà nước liên quan tổ chức thu đúng, thu đủ, thu kịp thời theo quy định của pháp luật; chịu sự chỉ đạo, kiểm tra của Bộ Tài chính, cơ quan quản lý cấp trên, Ủy ban nhân dân và sự giám sát của Hội đồng nhân dân về công tác thu ngân sách tại địa phương; phối hợp với Mặt trận Tổ quốc Việt Nam và các tổ chức thành viên tuyên truyền, vận động tổ chức, cá nhân thực hiện nghiêm nghĩa vụ nộp ngân sách theo quy định của Luật này và quy định khác của pháp luật có liên quan;</p>\n" +
            "\n" +
            "<p>b) Tổ chức quản lý và thực hiện thu thuế, phí, lệ phí và các khoản thu khác nộp trực tiếp vào Kho bạc Nhà nước. Trường hợp được phép thu qua ủy nhiệm thu thì phải nộp đầy đủ, đúng thời hạn vào Kho bạc Nhà nước theo quy định của Bộ Tài chính;</p>\n" +
            "\n" +
            "<p>c) Cơ quan thu có trách nhiệm đôn đốc, kiểm tra các cơ quan, tổ chức, đơn vị, cá nhân nộp đầy đủ, đúng hạn các khoản thu phải nộp vào ngân sách nhà nước;</p>\n" +
            "\n" +
            "<p>d) Kiểm tra, kiểm soát các nguồn thu của ngân sách; kiểm tra, thanh tra việc chấp hành kê khai, thu, nộp ngân sách và xử lý hành vi vi phạm theo quy định của pháp luật.</p>\n" +
            "\n" +
            "<p>4. Kho bạc Nhà nước được mở tài khoản tại Ngân hàng Nhà nước Việt Nam và ngân hàng thương mại để tập trung các khoản thu của ngân sách nhà nước; hạch toán đầy đủ, kịp thời các khoản thu vào ngân sách, điều tiết các khoản thu cho ngân sách các cấp theo đúng quy định.</p>\n";
    String dieu60="<p>1. Các nhiệm vụ chi đã bố trí trong dự toán được bảo đảm kinh phí theo đúng tiến độ thực hiện và trong phạm vi dự toán được giao.</p>\n" +
            "\n" +
            "<p>2. Đối với các dự án đầu tư và các nhiệm vụ chi cấp thiết khác được tạm ứng vốn, kinh phí để thực hiện các công việc theo hợp đồng đã ký kết. Mức vốn tạm ứng căn cứ vào giá trị hợp đồng và trong phạm vi dự toán ngân sách được giao và theo quy định của pháp luật có liên quan, vốn, kinh phí tạm ứng được thu hồi khi thanh toán khối lượng, nhiệm vụ hoàn thành.</p>\n" +
            "\n" +
            "<p>3. Ngân sách cấp dưới được tạm ứng từ ngân sách cấp trên để thực hiện nhiệm vụ chi theo dự toán ngân sách được giao trong trường hợp cần thiết.</p>\n" +
            "\n" +
            "<p>4. Căn cứ vào dự toán ngân sách được giao và yêu cầu thực hiện nhiệm vụ:</p>\n" +
            "\n" +
            "<p>a) Thủ trưởng đơn vị sử dụng ngân sách quyết định chi gửi Kho bạc Nhà nước để thực hiện;</p>\n" +
            "\n" +
            "<p>b) Cơ quan tài chính cấp dưới thực hiện rút số bổ sung từ ngân sách cấp trên tại Kho bạc Nhà nước.</p>\n" +
            "\n" +
            "<p>5. Kho bạc Nhà nước kiểm tra tính hợp pháp của các tài liệu cần thiết theo quy định của pháp luật và thực hiện chi ngân sách khi có đủ các điều kiện quy định tại khoản 2 Điều 12 của Luật này theo phương thức thanh toán trực tiếp hoặc tạm ứng theo quy định tại khoản 2 và khoản 3 Điều này.</p>\n" +
            "\n" +
            "<p>6. Thủ trưởng cơ quan Kho bạc Nhà nước từ chối thanh toán, chi trả các khoản chi không đủ các điều kiện quy định tại khoản 2 Điều 12 của Luật này và chịu trách nhiệm về quyết định của mình theo quy định của pháp luật.</p>\n";
    String dieu61="<p>1. Ngân sách trung ương, ngân sách cấp tỉnh và ngân sách cấp huyện được ứng trước dự toán ngân sách năm sau để thực hiện các dự án quan trọng quốc gia, các dự án cấp bách của trung ương và địa phương thuộc kế hoạch đầu tư trung hạn nguồn ngân sách nhà nước đã được cấp có thẩm quyền quyết định. Mức ứng trước không quá 20% dự toán chi đầu tư xây dựng cơ bản năm thực hiện của các công trình xây dựng cơ bản thuộc kế hoạch đầu tư trung hạn nguồn ngân sách nhà nước đã được phê duyệt. Khi phân bổ dự toán ngân sách năm sau, phải bố trí đủ dự toán để thu hồi hết số đã ứng trước; không được ứng trước dự toán năm sau khi chưa thu hồi hết số ngân sách đã ứng trước.</p>\n" +
            "\n" +
            "<p>2. Chính phủ quy định chi tiết các nguyên tắc, tiêu chí và điều kiện ứng trước dự toán ngân sách năm sau.</p>\n";
    String dieu62="<p>1. Trường hợp quỹ ngân sách trung ương thiếu hụt tạm thời thì được tạm ứng từ quỹ dự trữ tài chính trung ương và các nguồn tài chính hợp pháp khác để xử lý và phải hoàn trả trong năm ngân sách; nếu quỹ dự trữ tài chính và các nguồn tài chính hợp pháp khác không đáp ứng được thì Ngân hàng Nhà nước Việt Nam tạm ứng cho ngân sách trung ương theo quyết định của Thủ tướng Chính phủ. Việc tạm ứng từ Ngân hàng Nhà nước Việt Nam phải được hoàn trả trong năm ngân sách, trừ trường hợp đặc biệt do Ủy ban thường vụ Quốc hội quyết định.</p>\n" +
            "\n" +
            "<p>2. Trường hợp quỹ ngân sách cấp tỉnh thiếu hụt tạm thời thì được tạm ứng từ quỹ dự trữ tài chính địa phương, quỹ dự trữ tài chính trung ương và các nguồn tài chính hợp pháp khác để xử lý và phải hoàn trả trong năm ngân sách.</p>\n" +
            "\n" +
            "<p>3. Trường hợp quỹ ngân sách cấp huyện và cấp xã thiếu hụt tạm thời thì được tạm ứng từ quỹ dự trữ tài chính địa phương và các nguồn tài chính hợp pháp khác để xử lý và phải hoàn trả trong năm ngân sách.</p>\n";
    String dieu63="<p>1. Trường hợp dự kiến số thu không đạt dự toán được Quốc hội, Hội đồng nhân dân quyết định, thực hiện điều chỉnh giảm một số khoản chi theo quy định tại điểm a khoản 2 và điểm a khoản 3 Điều 52 của Luật này.</p>\n" +
            "\n" +
            "<p>2. Số tăng thu, trừ tăng thu của ngân sách địa phương do phát sinh nguồn thu từ dự án mới đi vào hoạt động trong thời kỳ ổn định ngân sách phải nộp về ngân sách cấp trên và số tiết kiệm chi ngân sách so với dự toán được sử dụng theo thứ tự ưu tiên như sau:</p>\n" +
            "\n" +
            "<p>a) Giảm bội chi, tăng chi trả nợ, bao gồm trả nợ gốc và lãi;</p>\n" +
            "\n" +
            "<p>b) Bổ sung quỹ dự trữ tài chính;</p>\n" +
            "\n" +
            "<p>c) Bổ sung nguồn thực hiện chính sách tiền lương;</p>\n" +
            "\n" +
            "<p>d) Thực hiện một số chính sách an sinh xã hội;</p>\n" +
            "\n" +
            "<p>đ) Tăng chi đầu tư một số dự án quan trọng;</p>\n" +
            "\n" +
            "<p>e) Thực hiện nhiệm vụ quy định tại khoản 3 và khoản 4 Điều này.</p>\n" +
            "\n" +
            "<p>Chính phủ lập phương án sử dụng số tăng thu và tiết kiệm chi của ngân sách trung ương, báo cáo Ủy ban thường vụ Quốc hội quyết định và báo cáo Quốc hội tại kỳ họp gần nhất. Ủy ban nhân dân lập phương án sử dụng số tăng thu và tiết kiệm chi ngân sách cấp mình, báo cáo Thường trực Hội đồng nhân dân quyết định và báo cáo Hội đồng nhân dân tại kỳ họp gần nhất. Đối với số tăng thu ngân sách địa phương do có phát sinh nguồn thu mới trong thời kỳ ổn định ngân sách thực hiện theo quy định tại điểm d khoản 7 Điều 9 của Luật này.</p>\n" +
            "\n" +
            "<p>3. Kết thúc năm ngân sách, trường hợp ngân sách địa phương hụt thu so với dự toán do nguyên nhân khách quan, sau khi đã thực hiện điều chỉnh giảm một số khoản chi theo quy định tại khoản 1 Điều này và sử dụng các nguồn lực tài chính hợp pháp khác của địa phương mà chưa bảo đảm được cân đối ngân sách địa phương thì ngân sách cấp trên hỗ trợ ngân sách cấp dưới theo khả năng của ngân sách cấp trên.</p>\n" +
            "\n" +
            "<p>4. Thưởng vượt dự toán các khoản thu phân chia giữa các cấp ngân sách:</p>\n" +
            "\n" +
            "<p>a) Trường hợp ngân sách trung ương tăng thu so với dự toán từ các khoản thu phân chia giữa ngân sách trung ương với ngân sách địa phương, ngân sách trung ương trích một phần theo tỷ lệ không quá 30% của số tăng thu thưởng cho các địa phương có tăng thu, nhưng không vượt quá số tăng thu so với mức thực hiện năm trước.</p>\n" +
            "\n" +
            "<p>Căn cứ vào mức thưởng do Ủy ban thường vụ Quốc hội quyết định, Ủy ban nhân dân cấp tỉnh báo cáo Hội đồng nhân dân cùng cấp quyết định sử dụng số thưởng vượt thu được hưởng để đầu tư xây dựng các chương trình, dự án kết cấu hạ tầng, thực hiện các nhiệm vụ quan trọng, thưởng cho ngân sách cấp dưới;</p>\n" +
            "\n" +
            "<p>b) Ủy ban nhân dân cấp tỉnh trình Hội đồng nhân dân cùng cấp quy định về việc thưởng vượt thu so với dự toán từ các khoản thu phân chia giữa các cấp ngân sách ở địa phương.</p>\n";
    String dieu64="<p>1. Cơ quan thuế và cơ quan hải quan các cấp định kỳ báo cáo cơ quan tài chính cùng cấp và các cơ quan có liên quan về thực hiện thu ngân sách nhà nước theo quy định của pháp luật.</p>\n" +
            "\n" +
            "<p>2. Kho bạc Nhà nước định kỳ báo cáo cơ quan tài chính cùng cấp và các cơ quan có liên quan về thực hiện thu, chi ngân sách nhà nước theo quy định của pháp luật.</p>\n" +
            "\n" +
            "<p>3. Đơn vị dự toán cấp I định kỳ báo cáo cơ quan tài chính cùng cấp và các cơ quan có liên quan về thực hiện thu, chi ngân sách nhà nước theo quy định của pháp luật.</p>\n" +
            "\n" +
            "<p>4. Cơ quan tài chính các cấp ở địa phương định kỳ báo cáo Ủy ban nhân dân cùng cấp và các cơ quan có liên quan về việc thực hiện thu, chi ngân sách địa phương; báo cáo cơ quan tài chính cấp trên về tình hình sử dụng các khoản bổ sung có mục tiêu từ ngân sách cấp trên theo quy định của pháp luật.</p>\n" +
            "\n" +
            "<p>5. Ủy ban nhân dân các cấp ở địa phương báo cáo Thường trực Hội đồng nhân dân cùng cấp các nội dung theo quy định tại khoản 3 Điều 52 và khoản 2 Điều 59 của Luật này; báo cáo Hội đồng nhân dân cùng cấp tình hình thực hiện ngân sách địa phương tại kỳ họp cuối năm và báo cáo đánh giá bổ sung tại kỳ họp giữa năm sau.</p>\n" +
            "\n" +
            "<p>6. Ủy ban nhân dân cấp dưới định kỳ báo cáo cơ quan tài chính cấp trên về thực hiện thu, chi ngân sách địa phương, Ủy ban nhân dân cấp tỉnh định kỳ báo cáo Bộ Tài chính về tình hình thực hiện thu ngân sách nhà nước trên địa bàn, tình hình thực hiện thu, chi ngân sách địa phương.</p>\n" +
            "\n" +
            "<p>7. Bộ Tài chính định kỳ báo cáo Chính phủ và các cơ quan có liên quan về thực hiện thu, chi ngân sách nhà nước theo quy định của pháp luật.</p>\n" +
            "\n" +
            "<p>8. Chính phủ báo cáo Ủy ban thường vụ Quốc hội các nội dung theo quy định tại khoản 2 Điều 52 và khoản 2 Điều 59 của Luật này; Chính phủ báo cáo Quốc hội tình hình thực hiện thu, chi ngân sách nhà nước tại kỳ họp cuối năm và báo cáo đánh giá bổ sung về tình hình thực hiện thu, chi ngân sách tại kỳ họp giữa năm sau.</p>\n";
    String dieu65="<p>1. Thủ trưởng đơn vị sử dụng ngân sách chịu trách nhiệm về việc quản lý, sử dụng ngân sách theo dự toán được giao, đánh giá kết quả thực hiện nhiệm vụ, bảo đảm hiệu quả, tiết kiệm, đúng chính sách, chế độ, tiêu chuẩn, định mức chi ngân sách.</p>\n" +
            "\n" +
            "<p>2. Người phụ trách công tác tài chính, kế toán tại đơn vị sử dụng ngân sách có nhiệm vụ thực hiện đúng chế độ quản lý tài chính - ngân sách, chế độ kế toán nhà nước, chế độ kiểm tra nội bộ và có trách nhiệm ngăn ngừa, phát hiện và kiến nghị thủ trưởng đơn vị, cơ quan tài chính cùng cấp xử lý đối với những trường hợp vi phạm.</p>\n";
    String dieu66="<p>1. Ngân quỹ nhà nước là toàn bộ các khoản tiền của Nhà nước có trên các tài khoản của Kho bạc Nhà nước mở tại Ngân hàng Nhà nước Việt Nam và các ngân hàng thương mại, tiền mặt tại các đơn vị Kho bạc Nhà nước. Ngân quỹ nhà nước được hình thành từ quỹ ngân sách các cấp và tiền gửi của các quỹ tài chính nhà nước, đơn vị, tổ chức kinh tế tại Kho bạc Nhà nước.</p>\n" +
            "\n" +
            "<p>2. Kho bạc Nhà nước quản lý tập trung, thống nhất ngân quỹ nhà nước để đáp ứng đầy đủ, kịp thời nhu cầu thanh toán, chi trả của ngân sách nhà nước và các đơn vị giao dịch tại Kho bạc Nhà nước; bảo đảm quản lý an toàn và sử dụng có hiệu quả ngân quỹ nhà nước.</p>\n" +
            "\n" +
            "<p>3. Chính phủ quy định chế độ quản lý ngân quỹ nhà nước.</p>\n";
    String dieu67="";
    String dieu68="<p>1. Các cơ quan, tổ chức, đơn vị, cá nhân có liên quan đến thu, chi ngân sách nhà nước phải tổ chức hạch toán kế toán, báo cáo và quyết toán ngân sách nhà nước theo đúng chế độ kế toán nhà nước và quy định của Luật này.</p>\n" +
            "\n" +
            "<p>2. Cơ quan tài chính có quyền tạm đình chỉ chi ngân sách của các cơ quan, tổ chức, đơn vị dự toán ngân sách cùng cấp không chấp hành đúng chế độ báo cáo kế toán, quyết toán, báo cáo tài chính khác và chịu trách nhiệm về quyết định của mình.</p>\n" +
            "\n" +
            "<p>3. Kho bạc Nhà nước tổ chức hạch toán kế toán ngân sách nhà nước; tổng hợp số liệu thu, chi ngân sách nhà nước, báo cáo cơ quan tài chính cùng cấp, các cơ quan có liên quan theo chế độ quy định.</p>\n    ";
    String dieu69="<p>1. Kết thúc năm ngân sách, các cơ quan, tổ chức, đơn vị, cá nhân có liên quan đến thu, chi ngân sách thực hiện khóa sổ kế toán và lập báo cáo quyết toán ngân sách nhà nước.</p>\n" +
            "\n" +
            "<p>2. Thời gian chỉnh lý quyết toán ngân sách nhà nước kết thúc vào ngày 31 tháng 01 năm sau.</p>\n" +
            "\n" +
            "<p>3. Các khoản dự toán chi, bao gồm cả các khoản bổ sung trong năm, đến hết năm ngân sách, kể cả thời gian chỉnh lý quyết toán ngân sách theo quy định tại khoản 2 Điều này chưa thực hiện được hoặc chưa chi hết phải hủy bỏ, trừ một số khoản chi được chuyển nguồn sang năm sau để thực hiện và hạch toán quyết toán vào ngân sách năm sau:</p>\n" +
            "\n" +
            "<p>a) Chi đầu tư phát triển thực hiện chuyển nguồn sang năm sau theo quy định của Luật đầu tư công;</p>\n" +
            "\n" +
            "<p>b) Chi mua sắm trang thiết bị đã đầy đủ hồ sơ, hợp đồng mua sắm trang thiết bị ký trước ngày 31 tháng 12 năm thực hiện dự toán;</p>\n" +
            "\n" +
            "<p>c) Nguồn thực hiện chính sách tiền lương;</p>\n" +
            "\n" +
            "<p>d) Kinh phí được giao tự chủ của các đơn vị sự nghiệp công lập và các cơ quan nhà nước;</p>\n" +
            "\n" +
            "<p>đ) Các khoản dự toán được cấp có thẩm quyền bổ sung sau ngày 30 tháng 9 năm thực hiện dự toán;</p>\n" +
            "\n" +
            "<p>e) Kinh phí nghiên cứu khoa học.</p>\n" +
            "\n" +
            "<p>4. Các khoản tăng thu, tiết kiệm chi được sử dụng theo quy định tại khoản 2 Điều 59 của Luật này, trường hợp phương án được cấp có thẩm quyền quyết định sử dụng vào năm sau thì được chuyển nguồn sang ngân sách năm sau để thực hiện.</p>\n" +
            "\n" +
            "<p>5. Chính phủ quy định chi tiết việc chuyển nguồn sang ngân sách năm sau.</p>\n";
    String dieu70="<p>1. Số liệu quyết toán ngân sách nhà nước phải chính xác, trung thực, đầy đủ.</p>\n" +
            "\n" +
            "<p>2. Số quyết toán thu ngân sách nhà nước là số thu đã thực nộp và số thu đã hạch toán thu ngân sách nhà nước theo quy định. Các khoản thu thuộc ngân sách các năm trước nộp ngân sách năm sau phải hạch toán vào thu ngân sách năm sau. Số quyết toán chi ngân sách nhà nước là số chi đã thực thanh toán và số chi đã hạch toán chi ngân sách nhà nước theo quy định.</p>\n" +
            "\n" +
            "<p>3. Số liệu quyết toán ngân sách của đơn vị sử dụng ngân sách, của chủ đầu tư và của ngân sách các cấp phải được đối chiếu, xác nhận với Kho bạc Nhà nước nơi giao dịch.</p>\n" +
            "\n" +
            "<p>4. Nội dung báo cáo quyết toán ngân sách nhà nước phải theo đúng các nội dung ghi trong dự toán ngân sách nhà nước được giao và theo mục lục ngân sách nhà nước.</p>\n" +
            "\n" +
            "<p>5. Báo cáo quyết toán của ngân sách cấp huyện, cấp xã không được quyết toán chi ngân sách lớn hơn thu ngân sách.</p>\n" +
            "\n" +
            "<p>6. Báo cáo quyết toán của đơn vị sử dụng ngân sách, đơn vị dự toán cấp trên, ngân sách các cấp phải kèm theo thuyết minh đánh giá kết quả, hiệu quả chi ngân sách gắn với kết quả thực hiện nhiệm vụ của đơn vị, địa phương, lĩnh vực, chương trình, mục tiêu được giao phụ trách.</p>\n" +
            "\n" +
            "<p>7. Báo cáo quyết toán của các quỹ tài chính nhà nước ngoài ngân sách phải kèm theo thuyết minh đánh giá kết quả, hiệu quả thực hiện nhiệm vụ của quỹ.</p>\n" +
            "\n" +
            "<p>8. Những khoản thu ngân sách nhà nước không đúng quy định của pháp luật phải được hoàn trả cho cơ quan, tổ chức, đơn vị, cá nhân đã nộp; những khoản thu ngân sách nhà nước nhưng chưa thu phải được truy thu đầy đủ cho ngân sách; những khoản chi ngân sách nhà nước không đúng với quy định của pháp luật phải được thu hồi đủ cho ngân sách.</p>\n";
    String dieu71="<p>1. Việc xét duyệt quyết toán năm được thực hiện theo các nội dung sau:</p>\n" +
            "\n" +
            "<p>a) Xét duyệt từng khoản thu, chi phát sinh tại đơn vị;</p>\n" +
            "\n" +
            "<p>b) Các khoản thu phải theo quy định của pháp luật về thuế, phí, lệ phí và các chế độ thu khác của Nhà nước;</p>\n" +
            "\n" +
            "<p>c) Các khoản chi phải bảo đảm các điều kiện chi quy định tại khoản 2 Điều 12 của Luật này;</p>\n" +
            "\n" +
            "<p>d) Các khoản thu, chi phải hạch toán theo đúng chế độ kế toán nhà nước, đúng mục lục ngân sách nhà nước, đúng niên độ ngân sách;</p>\n" +
            "\n" +
            "<p>đ) Các chứng từ thu, chi phải hợp pháp, số liệu trong sổ kế toán và báo cáo quyết toán phải khớp với chứng từ và khớp với số liệu của Kho bạc Nhà nước.</p>\n" +
            "\n" +
            "<p>2. Cơ quan xét duyệt quyết toán năm:</p>\n" +
            "\n" +
            "<p>a) Đơn vị dự toán cấp trên xét duyệt quyết toán của đơn vị dự toán cấp dưới trực thuộc theo quy định;</p>\n" +
            "\n" +
            "<p>b) Trường hợp đơn vị dự toán cấp I đồng thời là đơn vị sử dụng ngân sách thì cơ quan tài chính cùng cấp duyệt quyết toán ngân sách theo quy định đối với đơn vị dự toán cấp I cùng cấp.</p>\n" +
            "\n" +
            "<p>3. Khi xét duyệt quyết toán, cơ quan xét duyệt có quyền:</p>\n" +
            "\n" +
            "<p>a) Đề nghị Kiểm toán nhà nước hoặc thuê đơn vị kiểm toán độc lập theo quy định của pháp luật kiểm toán các báo cáo quyết toán của các dự án, chương trình mục tiêu có quy mô lớn để có thêm căn cứ cho việc xét duyệt;</p>\n" +
            "\n" +
            "<p>b) Yêu cầu đơn vị giải trình hoặc cung cấp thông tin, số liệu cần thiết để thực hiện việc xét duyệt quyết toán;</p>\n" +
            "\n" +
            "<p>c) Yêu cầu đơn vị nộp ngay các khoản phải nộp ngân sách nhà nước theo quy định và xuất toán các khoản chi sai chế độ, chi không đúng dự toán được duyệt; xử lý theo thẩm quyền hoặc đề nghị cơ quan có thẩm quyền xử lý đối với thủ trưởng đơn vị chi sai chế độ, gây thất thoát ngân sách nhà nước;</p>\n" +
            "\n" +
            "<p>d) Điều chỉnh những sai sót hoặc yêu cầu đơn vị cấp dưới lập lại báo cáo quyết toán nếu thấy cần thiết.</p>\n" +
            "\n" +
            "<p>4. Kết thúc việc xét duyệt quyết toán năm, đơn vị dự toán cấp trên ra thông báo duyệt quyết toán gửi đơn vị dự toán cấp dưới; đối với đơn vị dự toán cấp I gửi đơn vị dự toán cấp dưới và gửi cơ quan tài chính cùng cấp để thẩm định theo quy định.</p>\n" +
            "\n" +
            "<p>Cơ quan tài chính ra thông báo xét duyệt quyết toán đối với các đơn vị dự toán cấp I đồng thời là đơn vị sử dụng ngân sách.</p>\n" +
            "\n" +
            "<p>5. Thủ trưởng đơn vị xét duyệt quyết toán phải chịu trách nhiệm về kết quả duyệt quyết toán, nếu để xảy ra vi phạm mà không phát hiện hoặc đã phát hiện nhưng không xử lý sẽ bị xử lý theo quy định của pháp luật.</p>\n";
    String dieu72="<p>1. Cơ quan thẩm định quyết toán:</p>\n" +
            "\n" +
            "<p>a) Cơ quan tài chính các cấp thẩm định quyết toán năm của các đơn vị dự toán cấp I thuộc ngân sách cấp mình, trừ trường hợp quy định tại điểm b khoản 2 Điều 66 của Luật này;</p>\n" +
            "\n" +
            "<p>b) Cơ quan tài chính cấp tỉnh, cấp huyện thẩm định quyết toán năm của ngân sách cấp dưới;</p>\n" +
            "\n" +
            "<p>c) Đối với quyết toán ngân sách năm của các tỉnh, thành phố trực thuộc trung ương, Bộ Tài chính không thẩm định.</p>\n" +
            "\n" +
            "<p>2. Cơ quan tài chính các cấp thẩm định quyết toán năm của các đơn vị dự toán cấp I thuộc ngân sách cấp mình theo các nội dung sau:</p>\n" +
            "\n" +
            "<p>a) Kiểm tra tính đầy đủ và khớp đúng giữa các số liệu quyết toán theo quy định; bảo đảm khớp đúng giữa số liệu quyết toán của đơn vị dự toán cấp I với các thông báo duyệt quyết toán của cơ quan, đơn vị trực thuộc và xác nhận số liệu của Kho bạc Nhà nước;</p>\n" +
            "\n" +
            "<p>b) Xem xét, xác định tính chính xác và hợp pháp của số liệu quyết toán của các khoản tăng, giảm so với dự toán được giao;</p>\n" +
            "\n" +
            "<p>c) Nhận xét về quyết toán năm.</p>\n" +
            "\n" +
            "<p>3. Cơ quan tài chính cấp tỉnh, cấp huyện thẩm định quyết toán ngân sách cấp dưới theo các nội dung sau:</p>\n" +
            "\n" +
            "<p>a) Kiểm tra tính đầy đủ và khớp đúng giữa các số liệu quyết toán theo quy định;</p>\n" +
            "\n" +
            "<p>b) Xem xét, xác định tính chính xác và hợp pháp của số liệu quyết toán của các khoản tăng, giảm so với dự toán được giao;</p>\n" +
            "\n" +
            "<p>c) Nhận xét về quyết toán năm.</p>\n" +
            "\n" +
            "<p>4. Khi thẩm định quyết toán, cơ quan tài chính có quyền:</p>\n" +
            "\n" +
            "<p>a) Yêu cầu đơn vị dự toán cấp I, cơ quan tài chính cấp dưới bổ sung thông tin và số liệu cần thiết cho việc thẩm định quyết toán;</p>\n" +
            "\n" +
            "<p>b) Yêu cầu cơ quan có trách nhiệm xuất toán, thu hồi các khoản chi không đúng chế độ và yêu cầu nộp ngay các khoản phải nộp vào ngân sách nhà nước theo chế độ quy định;</p>\n" +
            "\n" +
            "<p>c) Yêu cầu cơ quan xét duyệt quyết toán điều chỉnh lại số liệu quyết toán của đơn vị dự toán ngân sách nếu có sai sót;</p>\n" +
            "\n" +
            "<p>d) Yêu cầu hoàn trả hoặc đề nghị cấp có thẩm quyền yêu cầu hoàn trả các khoản đã nộp ngân sách không đúng quy định của pháp luật.</p>\n" +
            "\n" +
            "<p>5. Kết thúc quá trình thẩm định quyết toán năm, cơ quan tài chính ra thông báo thẩm định quyết toán kèm theo nhận xét, kiến nghị gửi đơn vị dự toán cấp I hoặc Ủy ban nhân dân cấp dưới để thực hiện.</p>\n" +
            "\n" +
            "<p>Trường hợp phát hiện có sai sót, cơ quan tài chính yêu cầu đơn vị dự toán cấp I điều chỉnh lại số liệu quyết toán; đối với quyết toán ngân sách cấp dưới, cơ quan tài chính cấp trên yêu cầu Ủy ban nhân dân cấp dưới trình Hội đồng nhân dân cùng cấp điều chỉnh lại số liệu quyết toán.</p>\n" +
            "\n" +
            "<p>Trường hợp phát hiện sai phạm, cơ quan tài chính xử lý theo thẩm quyền hoặc đề nghị cơ quan có thẩm quyền xử lý theo quy định của pháp luật.</p>\n" +
            "\n" +
            "<p>6. Đối với quyết toán ngân sách của các tỉnh, thành phố trực thuộc trung ương, trong quá trình tổng hợp quyết toán ngân sách nhà nước, trường hợp phát hiện có sai sót, Bộ Tài chính yêu cầu Ủy ban nhân dân cấp tỉnh trình Hội đồng nhân dân cùng cấp điều chỉnh lại số liệu. Trường hợp phát hiện sai phạm, Bộ Tài chính xử lý theo thẩm quyền hoặc đề nghị cơ quan có thẩm quyền xử lý theo quy định của pháp luật.</p>\n";
    String dieu73="<p>1. Đơn vị sử dụng ngân sách lập quyết toán thu, chi ngân sách nhà nước của đơn vị mình gửi cơ quan dự toán cấp trên trực tiếp.</p>\n" +
            "\n" +
            "<p>2. Chủ đầu tư các chương trình, dự án đầu tư xây dựng cơ bản, các chương trình mục tiêu quốc gia, dự án quan trọng quốc gia:</p>\n" +
            "\n" +
            "<p>a) Kết thúc năm ngân sách phải báo cáo quyết toán nguồn vốn sử dụng, quyết toán nguồn vốn ngân sách, tình hình sử dụng vốn và giá trị khối lượng hoàn thành đã được quyết toán trong năm, gửi cơ quan cấp phát vốn đầu tư xây dựng cơ bản, cơ quan cấp trên của chủ đầu tư và cơ quan tài chính cùng cấp;</p>\n" +
            "\n" +
            "<p>b) Khi chương trình, dự án xây dựng cơ bản và chương trình mục tiêu quốc gia, dự án quan trọng quốc gia hoàn thành phải lập báo cáo quyết toán toàn bộ nguồn vốn, quyết toán nguồn vốn ngân sách kèm theo báo cáo thuyết minh tình hình sử dụng vốn gửi cơ quan cấp phát vốn đầu tư xây dựng cơ bản và cơ quan có thẩm quyền xét duyệt báo cáo quyết toán công trình xây dựng cơ bản, chương trình, dự án theo chế độ quy định;</p>\n" +
            "\n" +
            "<p>c) Đối với các chương trình mục tiêu quốc gia, dự án quan trọng quốc gia do Quốc hội quyết định chủ trương đầu tư, ngoài các quy định tại điểm a và điểm b khoản này còn phải lập báo cáo quyết toán trình Chính phủ xem xét để trình Quốc hội.</p>\n" +
            "\n" +
            "<p>3. Căn cứ vào quyết toán của đơn vị sử dụng ngân sách đã được duyệt, đơn vị dự toán cấp trên lập báo cáo quyết toán ngân sách nhà nước thuộc phạm vi quản lý gửi đơn vị dự toán cấp trên trực tiếp; đối với đơn vị dự toán cấp I gửi cơ quan tài chính cùng cấp.</p>\n" +
            "\n" +
            "<p>Đơn vị dự toán cấp I quy định thời hạn các đơn vị dự toán trực thuộc gửi báo cáo quyết toán, nhưng phải bảo đảm gửi báo cáo quyết toán cho cơ quan tài chính cùng cấp theo thời hạn quy định.</p>\n";
    String dieu74="<p>1. Trên cơ sở báo cáo của Kho bạc Nhà nước, kết quả xét duyệt, thẩm định đối với quyết toán ngân sách của các đơn vị dự toán cấp I thuộc cấp mình và báo cáo quyết toán ngân sách cấp dưới đã được Hội đồng nhân dân phê chuẩn, cơ quan tài chính ở địa phương tổng hợp, lập quyết toán ngân sách địa phương trình Ủy ban nhân dân cùng cấp.</p>\n" +
            "\n" +
            "<p>2. Ủy ban nhân dân gửi báo cáo quyết toán ngân sách địa phương đến Ban của Hội đồng nhân dân cùng cấp để thẩm tra; đồng thời gửi cơ quan tài chính cấp trên trực tiếp.</p>\n" +
            "\n" +
            "<p>3. Ủy ban nhân dân báo cáo Thường trực Hội đồng nhân dân cùng cấp quyết toán ngân sách địa phương để cho ý kiến trước khi trình Hội đồng nhân dân.</p>\n" +
            "\n" +
            "<p>4. Báo cáo quyết toán ngân sách của Ủy ban nhân dân và báo cáo thẩm tra của Ban của Hội đồng nhân dân được gửi đến các đại biểu Hội đồng nhân dân cùng cấp chậm nhất là 05 ngày làm việc trước ngày khai mạc kỳ họp giữa năm sau của Hội đồng nhân dân.</p>\n" +
            "\n" +
            "<p>5. Hội đồng nhân dân cấp xã xem xét, phê chuẩn báo cáo quyết toán ngân sách cấp mình, gửi Ủy ban nhân dân cấp huyện chậm nhất là 05 ngày làm việc, kể từ ngày báo cáo quyết toán được phê chuẩn. Ủy ban nhân dân cấp huyện tổng hợp, lập quyết toán ngân sách huyện trình Hội đồng nhân dân cấp huyện phê chuẩn, gửi Ủy ban nhân dân cấp tỉnh chậm nhất là 05 ngày làm việc, kể từ ngày báo cáo quyết toán được phê chuẩn. Ủy ban nhân dân cấp tỉnh tổng hợp, lập quyết toán ngân sách địa phương trình Hội đồng nhân dân cấp tỉnh phê chuẩn quyết toán ngân sách địa phương trước ngày 31 tháng 12 năm sau.</p>\n" +
            "\n" +
            "<p>Hội đồng nhân dân cấp tỉnh quy định cụ thể thời hạn phê chuẩn quyết toán ngân sách cấp xã, cấp huyện và quy định cụ thể thời hạn Ủy ban nhân dân gửi báo cáo quyết toán ngân sách đến các cơ quan quy định tại khoản 2 và khoản 3 Điều này.</p>\n" +
            "\n" +
            "<p>6. Trong trường hợp quyết toán các cấp ngân sách ở địa phương chưa được Hội đồng nhân dân phê chuẩn thì Ủy ban nhân dân cùng cấp và cơ quan Kiểm toán nhà nước đã thực hiện kiểm toán ngân sách cấp đó phải tiếp tục làm rõ những nội dung Hội đồng nhân dân yêu cầu và trình lại vào thời gian do Hội đồng nhân dân quyết định, nhưng không được chậm hơn 30 ngày so với thời hạn quy định tại khoản 5 Điều này.</p>\n";
    String dieu75="<p>1. Các đơn vị dự toán cấp I thuộc ngân sách trung ương lập báo cáo quyết toán thu, chi ngân sách thuộc phạm vi quản lý gửi về Bộ Tài chính, Kiểm toán nhà nước trước ngày 01 tháng 10 năm sau.</p>\n" +
            "\n" +
            "<p>2. Ủy ban nhân dân cấp tỉnh gửi Bộ Tài chính, Kiểm toán nhà nước báo cáo quyết toán ngân sách địa phương trước ngày 01 tháng 10 năm sau.</p>\n" +
            "\n" +
            "<p>3. Chậm nhất là 05 ngày làm việc, kể từ ngày Hội đồng nhân dân cấp tỉnh phê chuẩn quyết toán ngân sách địa phương, Ủy ban nhân dân cấp tỉnh gửi quyết toán ngân sách địa phương đến Bộ Tài chính, Kiểm toán nhà nước.</p>\n" +
            "\n" +
            "<p>4. Trên cơ sở báo cáo của Kho bạc Nhà nước, kết quả thẩm định báo cáo quyết toán của các đơn vị dự toán cấp I thuộc ngân sách trung ương và quyết toán ngân sách địa phương đã được Hội đồng nhân dân cấp tỉnh phê chuẩn, Bộ Tài chính tổng hợp, lập báo cáo quyết toán ngân sách nhà nước trình Chính phủ và gửi Kiểm toán nhà nước chậm nhất là 14 tháng sau khi kết thúc năm ngân sách.</p>\n" +
            "\n" +
            "<p>5. Chính phủ báo cáo Ủy ban thường vụ Quốc hội quyết toán ngân sách nhà nước chậm nhất là 16 tháng sau khi kết thúc năm ngân sách để cho ý kiến trước khi trình Quốc hội.</p>\n" +
            "\n" +
            "<p>6. Báo cáo quyết toán ngân sách nhà nước của Chính phủ được gửi đến các đại biểu Quốc hội chậm nhất là 20 ngày trước ngày khai mạc kỳ họp giữa năm của Quốc hội.</p>\n" +
            "\n" +
            "<p>7. Quốc hội xem xét, phê chuẩn quyết toán ngân sách nhà nước chậm nhất là 18 tháng sau khi kết thúc năm ngân sách.</p>\n" +
            "\n" +
            "<p>8. Trình tự, thủ tục thẩm tra của các cơ quan của Quốc hội về phê chuẩn quyết toán ngân sách nhà nước do Ủy ban thường vụ Quốc hội quy định.</p>\n" +
            "\n" +
            "<p>9. Trong trường hợp quyết toán ngân sách nhà nước chưa được Quốc hội phê chuẩn thì Chính phủ trong phạm vi nhiệm vụ, quyền hạn của mình và cơ quan Kiểm toán nhà nước phải tiếp tục làm rõ những nội dung Quốc hội yêu cầu để trình Quốc hội vào thời gian do Quốc hội quyết định.</p>\n";
    String dieu76="<p>1. Kiểm toán nhà nước thực hiện kiểm toán báo cáo quyết toán ngân sách nhà nước trước khi trình Quốc hội xem xét, phê chuẩn.</p>\n" +
            "\n" +
            "<p>2. Kiểm toán nhà nước thực hiện kiểm toán báo cáo quyết toán ngân sách địa phương trước khi gửi Hội đồng nhân dân cấp tỉnh xem xét, phê chuẩn.</p>\n";
    String dieu77="<p>1. Kết dư ngân sách trung ương, ngân sách cấp tỉnh được sử dụng để chi trả nợ gốc và lãi các khoản vay của ngân sách nhà nước. Trường hợp còn kết dư ngân sách thì trích 50% vào quỹ dự trữ tài chính cùng cấp; trích 50% còn lại vào thu ngân sách năm sau; trường hợp quỹ dự trữ tài chính đã đủ mức 25% dự toán chi ngân sách hằng năm thì số kết dư còn lại hạch toán vào thu ngân sách năm sau.</p>\n" +
            "\n" +
            "<p>2. Kết dư ngân sách cấp huyện, cấp xã được hạch toán vào thu ngân sách năm sau.</p>\n";
    String dieu78="\n" +
            "<p>Sau khi quyết toán ngân sách nhà nước và ngân sách các cấp chính quyền địa phương đã được cấp có thẩm quyền phê chuẩn, trường hợp phát hiện thu, chi ngân sách không đúng quy định thì thực hiện xử lý theo quy định tại khoản 8 Điều 65 của Luật này và được quyết toán vào ngân sách năm xử lý.</p>\n";
    String dieu79="";
    String dieu80="<p>1. Căn cứ vào quy định của Luật này, Chính phủ quy định về quản lý, sử dụng ngân sách đối với một số hoạt động thuộc lĩnh vực quốc phòng, an ninh, đối ngoại và một số cơ chế, chính sách tài chính - ngân sách đặc thù đối với thành phố Hồ Chí Minh, một số tỉnh, thành phố trực thuộc trung ương và đơn vị hành chính - kinh tế đặc biệt, báo cáo Ủy ban thường vụ Quốc hội cho ý kiến trước khi thực hiện, báo cáo Quốc hội tại kỳ họp gần nhất.</p>\n" +
            "\n" +
            "<p>2. Thành phố Hà Nội thực hiện một số cơ chế, chính sách tài chính - ngân sách đặc thù theo quy định của Luật Thủ đô.</p>\n";
    String dieu81="<p>1. Đối với quyết toán ngân sách các năm 2015, 2016, áp dụng theo các quy định của Luật ngân sách nhà nước số 01/2002/QH11.</p>\n" +
            "\n" +
            "<p>2. Thời kỳ ổn định ngân sách 2011 - 2015 được kéo dài đến hết năm 2016. Thời kỳ ổn định ngân sách tiếp theo được tính từ năm 2017 đến năm 2020. Đối với dự toán ngân sách năm 2016 của các bộ, cơ quan ngang bộ, cơ quan thuộc Chính phủ, cơ quan khác ở trung ương và các địa phương thực hiện như sau:</p>\n" +
            "\n" +
            "<p>a) Đối với dự toán ngân sách chi thường xuyên, áp dụng định mức phân bổ dự toán chi thường xuyên ngân sách nhà nước theo Quyết định số 59/2010/QĐ-TTg ngày 30 tháng 9 năm 2010 của Thủ tướng Chính phủ;</p>\n" +
            "\n" +
            "<p>b) Đối với dự toán ngân sách chi đầu tư phát triển, áp dụng các nguyên tắc, tiêu chí, định mức phân bổ vốn đầu tư thuộc nguồn vốn ngân sách nhà nước giai đoạn 2016 - 2020 theo Nghị quyết của Ủy ban thường vụ Quốc hội. Dự toán ngân sách chi đầu tư phát triển năm 2016 phải nằm trong khung kế hoạch đầu tư trung hạn 2016 - 2020 và được bố trí cân đối phù hợp với tốc độ tăng chi ngân sách nhà nước năm 2016 so với năm 2015.</p>\n";
    String dieu82="<p>1. Luật này có hiệu lực thi hành từ năm ngân sách 2017.</p>\n" +
            "\n" +
            "<p>2. Luật ngân sách nhà nước số 01/2002/QH11 hết hiệu lực kể từ ngày Luật này có hiệu lực thi hành.</p>\n";
    String dieu83="<p>Chính phủ quy định chi tiết các điều, khoản được giao trong Luật.</p>\n" +
            "\n" +
            "<p><i>Luật này đã được Quốc hội nước Cộng hòa xã hội chủ nghĩa Việt Nam khóa XIII, kỳ họp thứ 9 thông qua ngày 25 tháng 6 năm 2015.</i></p>\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_fullscreen);

        String[] thutu=getResources().getStringArray(R.array.position);
        tieude=getResources().getStringArray(R.array.tieude);
        //String[] noidung=getResources().getStringArray(R.array.noidung);

        for (int i=0;i<thutu.length;i++){
            lns1.put(thutu[i].toString(),tieude[i]);
            lns2.put(thutu[i].toString(),"");
        }

        lns2.put("1",dieu1);
        lns2.put("2",dieu2);
        lns2.put("3",dieu3);
        lns2.put("4",dieu4);
        lns2.put("5",dieu5);
        lns2.put("6",dieu6);
        lns2.put("7",dieu7);
        lns2.put("8",dieu8);
        lns2.put("9",dieu9);
        lns2.put("10",dieu10);
        lns2.put("11",dieu11);
        lns2.put("12",dieu12);
        lns2.put("13",dieu13);
        lns2.put("14",dieu14);
        lns2.put("15",dieu15);
        lns2.put("16",dieu16);
        lns2.put("17",dieu17);
        lns2.put("18",dieu18);
        lns2.put("19",dieu19);
        lns2.put("20",dieu20);
        lns2.put("21",dieu21);
        lns2.put("22",dieu22);
        lns2.put("23",dieu23);
        lns2.put("24",dieu24);
        lns2.put("25",dieu25);
        lns2.put("26",dieu26);
        lns2.put("27",dieu27);
        lns2.put("28",dieu28);
        lns2.put("29",dieu29);
        lns2.put("30",dieu30);
        lns2.put("31",dieu31);
        lns2.put("32",dieu32);
        lns2.put("33",dieu33);
        lns2.put("34",dieu34);
        lns2.put("35",dieu35);
        lns2.put("36",dieu36);
        lns2.put("37",dieu37);
        lns2.put("38",dieu38);
        lns2.put("39",dieu39);
        lns2.put("40",dieu40);
        lns2.put("41",dieu41);
        lns2.put("42",dieu42);
        lns2.put("43",dieu43);
        lns2.put("44",dieu44);
        lns2.put("45",dieu45);
        lns2.put("46",dieu46);
        lns2.put("47",dieu47);
        lns2.put("48",dieu48);
        lns2.put("49",dieu49);
        lns2.put("50",dieu50);
        lns2.put("51",dieu51);
        lns2.put("52",dieu52);
        lns2.put("53",dieu53);
        lns2.put("54",dieu54);
        lns2.put("55",dieu55);
        lns2.put("56",dieu56);
        lns2.put("57",dieu57);
        lns2.put("58",dieu58);
        lns2.put("59",dieu59);
        lns2.put("60",dieu60);
        lns2.put("61",dieu61);
        lns2.put("62",dieu62);
        lns2.put("63",dieu63);
        lns2.put("64",dieu64);
        lns2.put("65",dieu65);
        lns2.put("66",dieu66);
        lns2.put("67",dieu67);
        lns2.put("68",dieu68);
        lns2.put("69",dieu69);
        lns2.put("70",dieu70);
        lns2.put("71",dieu71);
        lns2.put("72",dieu72);
        lns2.put("73",dieu73);
        lns2.put("74",dieu74);
        lns2.put("75",dieu75);
        lns2.put("76",dieu76);
        lns2.put("77",dieu77);
        lns2.put("78",dieu78);
        lns2.put("79",dieu79);
        lns2.put("80",dieu80);
        lns2.put("81",dieu81);
        lns2.put("82",dieu82);
        lns2.put("83",dieu83);

        String currDate= DateFormat.getDateInstance().format(new Date());

        if (currDate.indexOf("2016")>0){
            populateListView();
            registerClickCallback();
        }
    }

    private void registerClickCallback() {
        ListView list = (ListView) findViewById(R.id.listView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> paret, View viewClicked, int position, long id) {

                TextView textView = (TextView) viewClicked;
                String message = "You clicked # " + position + " " + textView.getText().toString();
                //Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                Intent i=new Intent(getApplicationContext(), FullscreenActivity2.class);

                String positionstr= ""+position;
                i.putExtra("position",position);

                i.putExtra("tieude",lns1.get(positionstr));
                i.putExtra("noidung",lns2.get(positionstr));
                startActivity(i);
            }
        });
    }

    private void populateListView() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, // Context for the activity.
                R.layout.da_item, // Layout to use (create)
                tieude); // Items to be displayed // Configure the list view.
        ListView list = (ListView) findViewById(R.id.listView);

        list.setAdapter(adapter);
    }
}
