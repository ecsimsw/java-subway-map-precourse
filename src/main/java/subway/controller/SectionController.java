package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class SectionController {
    private static SectionController sectionController = null;
    private final Scanner scanner;

    private SectionController(Scanner scanner) {
        this.scanner = scanner;
    }

    public static SectionController getInstance(Scanner scanner) {
        if (sectionController == null) {
            return new SectionController(scanner);
        }
        return sectionController;
    }

    public void addSection() {
        OutputView.printMsg("## 노선을 입력하세요.\n");
        String lineName = InputView.getInput(scanner);
        Line line = LineRepository.getLineByName(lineName);
        //TODO :: 존재하는 노선 인지 확인
        OutputView.printMsg("## 역이름을 입력하세요.\n");
        String stationName = InputView.getInput(scanner);
        Station station = StationRepository.getStationByName(stationName);

        OutputView.printMsg("## 순서를 입력하세요.\n");
        int order = Integer.parseInt(InputView.getInput(scanner));
        line.addStation(order, station);

        OutputView.printInfoMsg("구간이 등록되었습니다.");
    }
}
