package subway.view;

import subway.domain.Name;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Scanner;

public class LineView {
    private static LineView lineView;
    private final Scanner scanner;

    private LineView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static LineView getInstance(Scanner scanner) {
        if (lineView == null) {
            lineView = new LineView(scanner);
            return lineView;
        }
        return lineView;
    }

    public Name getLineNameToAdd() {
        OutputView.printMsg("## 등록할 노선 이름을 입력하세요.\n");
        return InputView.getName(scanner);
    }

    public Name getFirstStationName() {
        OutputView.printMsg("## 등록할 노선의 상행 종점역 이름을 입력하세요.\n");
        return InputView.getName(scanner);
    }

    public Name getLastStationName() {
        OutputView.printMsg("## 등록할 노선의 하행 종점역 이름을 입력하세요.\n");
        return InputView.getName(scanner);
    }

    public void announceAdditionSuccess() {
        OutputView.printInfoMsg("지하철 노선이 등록되었습니다.");
    }

    public Name getLineNameToDelete() {
        OutputView.printMsg("## 삭제할 노선 이름을 입력하세요.\n");
        return InputView.getName(scanner);
    }

    public void announceDeletionSuccess() {
        OutputView.printInfoMsg("지하철 노선이 삭제되었습니다.");
    }

}
