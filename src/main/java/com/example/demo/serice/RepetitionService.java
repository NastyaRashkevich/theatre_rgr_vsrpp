package com.example.demo.serice;

import com.example.demo.entity.Repetition;

public interface RepetitionService extends IService<Repetition>{

    Repetition findByPlace (String place);
}
