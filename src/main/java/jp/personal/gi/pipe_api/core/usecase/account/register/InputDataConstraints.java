package jp.personal.gi.pipe_api.core.usecase.account.register;

import jp.personal.gi.pipe_api.core.usecase.account.register.error.*;

import java.util.*;

/**
 * 入力値の制約
 */
public class InputDataConstraints {
    /**
     * 渡された入力値が、制約に沿っているかチェックする。
     *
     * @param inputData 入力値
     * @throws IllegalInputDataException 制約に違反している場合
     */
    public void check(InputData inputData) throws IllegalInputDataException {
        if (Objects.isNull(inputData)) throw new IllegalInputDataException("inputDataが存在しません。");
        if (Objects.isNull(inputData.getName())) throw new IllegalInputDataException("nameが存在しません。", inputData);
        if (Objects.isNull(inputData.getNameReading()))
            throw new IllegalInputDataException("nameReadingが存在しません。", inputData);
        if (Objects.isNull(inputData.getAuthority()))
            throw new IllegalInputDataException("authorityが存在しません。", inputData);

        if (inputData.getName().trim().isEmpty()) throw new IllegalInputDataException("nameがブランクです。", inputData);
    }
}
