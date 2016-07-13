function [ output_args ] = Untitled2( input_args )
%UNTITLED2 Summary of this function goes here
%   Detailed explanation goes here

classdef TestLength < matlab.unittest.TestCase
     
    methods (Test)
         
        function testMmToMetres(tc)
            tc.assertEqual(ConvertLength(1000, 'mm', 'metre'), 1);
        end
                 
    end
     
end

end

