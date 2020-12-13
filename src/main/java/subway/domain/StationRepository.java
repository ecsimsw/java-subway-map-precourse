package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static void remove(Station station) {
        if (station.isOnLine()) {
            throw new IllegalArgumentException("노선에 등록된 역은 제거할 수 없습니다.");
        }
        stations.remove(station);
    }

    public static boolean deleteStation(Name name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static List<String> getStationNames() {
        return stations.stream()
                .map(Station::toString)
                .collect(Collectors.toList());
    }

    public static Station getByName(Name name) {
        return stations.stream()
                .filter(station -> station.isSameName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 역입니다."));
    }

    public static boolean isExistingName(Name name) {
        return stations.stream()
                .anyMatch(station -> station.isSameName(name));
    }
}
